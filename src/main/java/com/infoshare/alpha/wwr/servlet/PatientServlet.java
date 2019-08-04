package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.common.*;
import com.infoshare.alpha.wwr.domain.facilities.dao.FacilityDao;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.patients.PatientsService;
import com.infoshare.alpha.wwr.domain.patients.dao.PatientDao;
import com.infoshare.alpha.wwr.domain.patients.entity.Parent;
import com.infoshare.alpha.wwr.domain.patients.dao.ParentDao;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModel;
import com.infoshare.alpha.wwr.servlet.validators.PatientServletValidator;
import com.infoshare.alpha.wwr.servlet.validators.PatientValidationException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "PatientServlet", urlPatterns = {"/patient"})
@Transactional
public class PatientServlet extends BaseWwrServlet {

    private static final String PATIENTS_TEMPLATE_PATH = "/patient/patients.ftlh";

    @Inject
    PatientsService patientsService;

    @Inject
    PatientsReadModel patientsReadModel;

    @Inject
    PatientServletValidator patientServletValidator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req,resp);

        List<Patient> patients = patientsReadModel.getAll();

        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> model = new HashMap<>();
        model.put("patients", patients);
        this.renderView(model, PATIENTS_TEMPLATE_PATH);

        //TODO: uwaga przy relacji many to many zeby mapowac wynik zapytania dla gsona.
        //this.renderJson(services.stream().findFirst().get().toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            resp.setContentType("text/html;charset=UTF-8");
            req.setCharacterEncoding("UTF-8");

            patientServletValidator.validatePutRequest(req.getParameterMap());

            String nameParam = req.getParameter("name");
            String surnameParam = req.getParameter("surname");
            String peselParam = req.getParameter("pesel");
            String streetParam = req.getParameter("street");
            String cityParam = req.getParameter("city");
            String phoneParam = req.getParameter("phone");
            String postalCodeParam = req.getParameter("postalCode");
            String parentNameParam = req.getParameter("parentName");
            String parentSurnameParam = req.getParameter("parentSurname");

            Integer postalCode = Integer.parseInt(postalCodeParam);

            Patient patient = new Patient(nameParam, surnameParam, new Pesel(peselParam), new Address(cityParam, streetParam, phoneParam, postalCode), new Parent(parentNameParam, parentSurnameParam, new Pesel(peselParam)));

            patientsService.add(patient);

            resp.getWriter().println("<!DOCTYPE html><html><body>");
            resp.getWriter().println("<input type=\"button\" value=\"Powrót do formularza\" onclick=\"history.back()\">");
            resp.getWriter().println("<div><strong>Pacjent:</strong> " + patient.getName() + " " + patient.getSurname() + "<strong> - został dodany pomyślnnie.</strong></div>");
            resp.getWriter().println("</body></html>\n");

        } catch (IOException | PeselException e) {
            e.printStackTrace();
            resp.getWriter().println("<!DOCTYPE html><html><body>");
            resp.getWriter().println("<input type=\"button\" value=\"Powrót do formularza\" onclick=\"history.back()\">");
            resp.getWriter().println(e.getMessage());
            resp.getWriter().println("</body></html>\n");
        } catch (PatientValidationException e) {
            resp.getWriter().println("<!DOCTYPE html><html><body>");
            resp.getWriter().println("<input type=\"button\" value=\"Powrót do formularza\" onclick=\"history.back()\">");
            resp.getWriter().println(e.getMessage());
            resp.getWriter().println("</body></html>\n");
        }
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
