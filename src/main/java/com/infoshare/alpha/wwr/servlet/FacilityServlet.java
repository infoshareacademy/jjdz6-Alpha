package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.domain.facilities.FacilitiesService;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDb;
import com.infoshare.alpha.wwr.servlet.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility", "/find-facilities"})
public class FacilityServlet extends BaseWwrServlet {

    @Inject
    private FacilitiesService facilitiesService;
    @Inject
    private FacilitiesReadModel facilitiesReadModel;
    @Inject
    private PatientsReadModelDb patientsReadModelDb;
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchByParam = req.getParameter("searchBy");
        PrintWriter writer = resp.getWriter();
        Map<String, Object> model = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(), "find-facilities-by-patient.ftlh");


        if (searchByParam != null) {

            Patient selectedPatient = patientsReadModelDb.getAll().getPatients()
                    .stream()
                    .filter(p -> p.getPesel().toString().contains(searchByParam)) // TODO wyszukiwanie po innym parametrze, by nie przekazywać peselu w URL?
                    .findAny()
                    .orElse(null); // TODO .get() też zwróci null jeśli Optional będzie pusty?
            // TODO przechwycić nulla lub zwrócić co innego
            List<Facility> selectedPatientsFacilities = facilitiesReadModel.getByPatient(new FacilityPatientQuery(selectedPatient, Arrays.asList(FacilityQueryField.CITY)));

            model.put("selectedPatient", selectedPatient);
            model.put("selectedPatientsFacilities", selectedPatientsFacilities);
        }

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            e.getMessage();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
