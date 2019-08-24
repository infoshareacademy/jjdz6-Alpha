package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.domain.facilities.FacilitiesService;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityDeleteCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityEditCommand;
import com.infoshare.alpha.wwr.domain.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.servlet.validators.FacilityServletValidator;
import com.infoshare.alpha.wwr.servlet.validators.FacilityValidationException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
@Transactional
public class FacilityServlet extends BaseWwrServlet {

    private static final String FACILITY_EDIT_TEMPLATE_PATH = "/facility/editFacility.ftlh";
    private static final String FACILITIES_TEMPLATE_PATH = "/facility/facilities.ftlh";

    @Inject
    FacilitiesService facilitiesService;

    @Inject
    FacilitiesReadModel facilitiesReadModel;

    @Inject
    FacilitiesReadModelDbRepository facilitiesReadModelDbRepository;

    @Inject
    FacilityServletValidator facilityServletValidator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            super.doGet(req, resp);

            Optional<String> action = Optional.ofNullable(req.getParameter("action"));
            Optional<String> id = Optional.ofNullable(req.getParameter("id"));

            if (action.isPresent() && action.get().equalsIgnoreCase("DELETE") && id.isPresent()) {
                deleteFacility(Integer.valueOf(id.get()));
                renderFacilities();
                return;
            }

            if (!id.isPresent()) {
                renderFacilities();
                return;
            }

            Optional<Facility> facility = facilitiesReadModel.getById(Integer.parseInt(id.get()));

            if (!facility.isPresent()) {
                renderEditFacilityNotFound();
                return;
            }

            renderEditFacility(facility.get());

        } catch (FacilitiesException e) {
            this.logError(e.getMessage(), e.hashCode());
            renderFacilitiesWithError(e);
        } catch (NumberFormatException | IOException e) {
            this.logError(e.getMessage(), e.hashCode());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            super.doPut(req, resp);

            facilityServletValidator.validatePutRequest(req.getParameterMap());

            Facility facility = getFacilityFromRequestData(req.getParameterMap());

            facilitiesService.edit(new FacilityEditCommand(facility));

            response.setStatus(HttpServletResponse.SC_OK);
            Map<String, Object> model = new HashMap<>();
            model.put("editSuccess", true);
            model.put("facility", facility);
            this.renderView(model, FACILITY_EDIT_TEMPLATE_PATH);

        } catch (FacilityValidationException e) {
            this.logError(e.getMessage(), e.getCode());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            Map<String, Object> model = new HashMap<>();
            model.put("validationError", e);
            model.put("facility", this.getFacilityFromRequestData(req.getParameterMap()));
            this.renderView(model, FACILITY_EDIT_TEMPLATE_PATH);

        } catch (FacilitiesException e) {

            this.logError(e.getMessage(), e.getCode());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            Map<String, Object> model = new HashMap<>();
            model.put("facility", this.getFacilityFromRequestData(req.getParameterMap()));
            model.put("serviceError", new FacilitiesException(e.getMessage(), FacilitiesException.FACILITY_SERVICE_ERROR_CODE));
            this.renderView(model, FACILITY_EDIT_TEMPLATE_PATH);
        }
    }

    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void deleteFacility(int id) throws FacilitiesException {

        Optional<Facility> facility = facilitiesReadModel.getById(id);

        if (!facility.isPresent()) {
            throw FacilitiesException.facilityNotFound();
        }

        facilitiesService.delete(new FacilityDeleteCommand(facility.get()));
    }

    private void renderEditFacilityNotFound() throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        Map<String, Object> model = new HashMap<>();
        model.put("notFoundError", true);
        this.renderView(model, FACILITY_EDIT_TEMPLATE_PATH);
    }

    private void renderEditFacility(Facility facility) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> model = new HashMap<>();
        model.put("facility", facility);
        this.renderView(model, FACILITY_EDIT_TEMPLATE_PATH);
    }

    private void renderFacilitiesWithError(Object error) throws IOException {
        List<Facility> facilities = facilitiesReadModelDbRepository.getAll();
        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> model = new HashMap<>();
        model.put("facilities", facilities);
        model.put("serviceError", error);
        this.renderView(model, FACILITIES_TEMPLATE_PATH);
        return;
    }

    private void renderFacilities() throws IOException {
        List<Facility> facilities = facilitiesReadModelDbRepository.getAll();
        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> model = new HashMap<>();
        model.put("facilities", facilities);
        this.renderView(model, FACILITIES_TEMPLATE_PATH);
        return;
    }

    private Facility getFacilityFromRequestData(Map<String, String[]> requestData) {
        int id = Integer.valueOf(requestData.get("facility_id")[0]);
        String isNfz = requestData.get("nfz")[0];
        String name = requestData.get("facility_name")[0];
        String city = requestData.get("facility_address_city")[0];
        String street = requestData.get("facility_address_street")[0];
        String phone = requestData.get("facility_address_phone")[0];


        String postal = requestData.get("facility_address_postal")[0];

        int postalNumber = 0;
        try {
            if (!postal.equals("")) {
                postalNumber = Integer.valueOf(postal);
            }
        } catch (NumberFormatException e) {
            this.logger.severe("Postal number can't be converted to int");
        }

        String[] servicesData = requestData.get("service[]");

        List<Service> services = new ArrayList<>();
        if (servicesData != null && servicesData.length != 0) {
            services = Arrays.stream(servicesData).map(Service::new).collect(Collectors.toList());
        }

        return new Facility(id, name, new Address(city, street, phone, postalNumber),Boolean.valueOf(isNfz), services);
    }

}
