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
import java.util.*;
import java.util.stream.Collectors;

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

        String patientName = req.getParameter("patient");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Map<String, Object> model = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(), "find-facilities-by-patient.ftlh");


        if (patientName != null) {
            String formattedPatientName = patientName.toLowerCase();

            List<Patient> selectedPatients = patientsReadModelDb.getAll().getPatients()
                    .stream()
                    .filter(p -> p.getName().toLowerCase().contains(formattedPatientName) || p.getSurname().toLowerCase().contains(formattedPatientName))
                    .collect(Collectors.toList());

            Map<Patient, List<Facility>> facilitiesByPatient = selectedPatients
                    .stream()
                    .collect(Collectors.toMap(patient -> patient,
                            patientsFacilities -> facilitiesReadModel.getByPatient(new FacilityPatientQuery(patientsFacilities, Arrays.asList(FacilityQueryField.CITY)))));
            // TODO w przypadku braku placówek doda pustą listę placówek?
            // TODO sortowanie po nazwisku pacjenta
            model.put("selectedPatients", selectedPatients);
            model.put("selectedPatientsFacilities", facilitiesByPatient);
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
