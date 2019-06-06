package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQuery;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQueryFields;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModel;
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

@WebServlet("/find-facilities")
public class PatientsFacilitiesServlet extends BaseWwrServlet {

    @Inject
    private FacilitiesReadModel facilitiesReadModel;
    @Inject
    private PatientsReadModel patientsReadModel;
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String patientsPesel = req.getParameter("patient");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> model = new HashMap<>();

        try {
            PrintWriter writer = resp.getWriter();
            Template template = templateProvider.getTemplate(getServletContext(), "find-facilities-by-patient.ftlh");

            if (patientsPesel != null && !Objects.equals(patientsPesel, "")) {
                Map<PatientQueryFields, String> patientQueryFieldsMap = new EnumMap<>(PatientQueryFields.class);
                patientQueryFieldsMap.put(PatientQueryFields.SURNAME, patientsPesel);
                List<Patient> selectedPatients = patientsReadModel.getByQuery(new PatientQuery(patientQueryFieldsMap)).getPatients();

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
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(resp.getStatus() + "Internal Server Error");
        }
    }
}
