package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.domain.facilities.FacilitiesService;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityAddCommand;
import com.infoshare.alpha.wwr.servlet.validators.FacilityServletValidator;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddFacilityServlet", urlPatterns = {"/facility-add"})
public class AddFacilityServlet extends BaseWwrServlet {

    private final String FACILITY_ADD_TEMPLATE_PATH = "/facility/addFacility.ftlh";
    private final String FACILITY_ADD_CONFIRM_TEMPLATE_PATH = "/facility/addFacilityConfirm.ftlh";

    @Inject
    FacilitiesService facilitiesService;

    @Inject
    FacilityServletValidator facilityServletValidator;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        super.doGet(req, resp);
        Map<String, Object> model = new HashMap<>();
        renderView(model, FACILITY_ADD_TEMPLATE_PATH);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        Boolean isNfz = Boolean.valueOf(req.getParameter("isNfz"));
        String name = req.getParameter("name");
        String street = req.getParameter("street");
        String city = req.getParameter("city");
        String phone = req.getParameter("phone");
        Integer postalCode = Integer.parseInt(req.getParameter("postalCode"));
        String[] services = req.getParameterValues("services");
        Boolean terms = Boolean.valueOf(req.getParameter("terms"));

        FacilityAddCommand facilityAddCommand = new FacilityAddCommand(name, city, street, phone, postalCode, isNfz, services);

        if (terms) {
            facilitiesService.add(facilityAddCommand);
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> model = new HashMap<>();
        model.put("facility", facilityAddCommand.getFacility());
        this.renderView(model, FACILITY_ADD_CONFIRM_TEMPLATE_PATH);
    }
}
