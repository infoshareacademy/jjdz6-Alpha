package com.infoshare.alpha.wwr.servlet;

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
    private FacilitiesReadModel facilitiesReadModel;
    @Inject
    private PatientsReadModelDb patientsReadModelDb;
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String patientName = req.getParameter("patient");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> model = new HashMap<>();

        try {
            PrintWriter writer = resp.getWriter();
            Template template = templateProvider.getTemplate(getServletContext(), "find-facilities-by-patient.ftlh");

            if (patientName != null && !Objects.equals(patientName, "")) {
                String formattedPatientName = patientName.toLowerCase();

                List<Patient> selectedPatients = patientsReadModelDb.getAll().getPatients()
                        .stream()
                        .filter(p -> p.getName().toLowerCase().contains(formattedPatientName) || p.getSurname().toLowerCase().contains(formattedPatientName))
                        .collect(Collectors.toList());

                Map<Patient, List<Facility>> facilitiesByPatient = new TreeMap<>();
                selectedPatients.forEach(patient -> facilitiesByPatient.put(
                        patient,
                        facilitiesReadModel.getByPatient(new FacilityPatientQuery(patient, Collections.singletonList(FacilityQueryField.POSTAL_CODE)))
                ));

                model.put("selectedPatients", selectedPatients);
                model.put("selectedPatientsFacilities", facilitiesByPatient);
            }
            template.process(model, writer);
        } catch (IOException | TemplateException e) {
            // TODO send response to user
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
