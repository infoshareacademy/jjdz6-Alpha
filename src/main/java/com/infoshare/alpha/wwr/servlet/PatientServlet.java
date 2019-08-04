package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.domain.patients.PatientsService;
import com.infoshare.alpha.wwr.domain.patients.entity.Parent;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModel;
import com.infoshare.alpha.wwr.servlet.validators.PatientServletValidator;
import com.infoshare.alpha.wwr.servlet.validators.PatientValidationException;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PatientServlet", urlPatterns = {"/patient"})
public class PatientServlet extends BaseWwrServlet {

    private final String PATIENT_ADD_TEMPLATE_PATH = "/patient/addPatient.ftlh";

    @Inject
    PatientsService patientsService;

    @Inject
    PatientsReadModel patientsReadModel;

    @Inject
    PatientServletValidator patientServletValidator;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        Map<String, Object> model = new HashMap<>();
        renderView(model, PATIENT_ADD_TEMPLATE_PATH);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            resp.setContentType("text/html;charset=UTF-8");
            req.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            Template template = templateProvider.getTemplate(getServletContext(), PATIENT_ADD_TEMPLATE_PATH);
            Map<String, Object> model = new HashMap<>();


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

            Patient patient = new Patient(nameParam, surnameParam, new Pesel(peselParam), new Address(cityParam, streetParam, phoneParam, postalCode), new Parent(parentNameParam, parentSurnameParam));

            patientsService.add(patient);


            model.put("editSuccess", true);
            model.put("patient", patient);
            template.process(model, writer);

        } catch (IOException | PeselException e) {
            e.printStackTrace();
            resp.getWriter().println("<!DOCTYPE html><html><body>");
            resp.getWriter().println("<input type=\"button\" value=\"Powrót do formularza\" onclick=\"history.back()\">");
            resp.getWriter().println(e.getMessage());
            resp.getWriter().println("</body></html>\n");
        } catch (PatientValidationException | TemplateException e) {
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
