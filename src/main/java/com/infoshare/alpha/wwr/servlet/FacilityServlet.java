package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.utils.ErrorResponse;
import com.infoshare.alpha.wwr.utils.freemaker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
public class FacilityServlet extends BaseWwrServlet {

    @Inject
    FacilitiesReadModel facilitiesReadModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            super.doGet(req, resp);

            String id = req.getParameter("id");
            config.register(this.getServletContext());

            if (null == id) {
                throw new IOException("Id param missing.");
            }

            Facility facility = facilitiesReadModel.getById(Integer.valueOf(id));

            if (null == facility) {
                throw new IOException("Facility id: " + id + " not found.");
            }

            response.setStatus(HttpServletResponse.SC_OK);
            Map<String, Object> model = new HashMap<>();
            model.put("facility", facility);
            this.renderView(model, "/facility/editFacility.ftlh");

        } catch (IOException | TemplateException | NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            if (e instanceof NumberFormatException) {
                responsePrinter.print(response, gson.toJson(new ErrorResponse("Id not found.", HttpServletResponse.SC_BAD_REQUEST)));
            } else {
                responsePrinter.print(response, gson.toJson(new ErrorResponse(e.getMessage(), HttpServletResponse.SC_BAD_REQUEST)));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String facilityId = parameterMap.get("facility_id")[0];
        String facilityName = parameterMap.get("facility_name")[0];
        String facilityAddressCity = parameterMap.get("facility_address_city")[0];
        String facilityAddressStreet = parameterMap.get("facility_address_street")[0];
        String[] services = parameterMap.get("service[]");


        parameterMap.keySet().stream().forEach(k -> {logger.severe(k);});
        logger.severe("Facility name: " + facilityName);
        parameterMap.forEach((k,v)->{
            logger.severe("Key :" + k + " Value: " + v.toString());
        });

    }

    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
