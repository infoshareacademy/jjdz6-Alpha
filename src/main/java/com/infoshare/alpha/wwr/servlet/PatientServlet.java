package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.domain.patients.PatientsService;
import com.infoshare.alpha.wwr.domain.patients.entity.Parent;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PatientServlet", urlPatterns = {"/patient"})
public class PatientServlet extends BaseWwrServlet {

    @Inject
    PatientsService patientsService;

    @Inject
    PatientsReadModel patientsReadModel;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String nameParam = req.getParameter("name");
        String surnameParam = req.getParameter("surname");
        String peselParam = req.getParameter("pesel");
        String streetParam = req.getParameter("street");
        String cityParam = req.getParameter("city");
        String phoneParam = req.getParameter("phone");
        String parentNameParam = req.getParameter("parentName");
        String parentSurnameParam = req.getParameter("parentSurname");


        try {


            Patient patient = new Patient(nameParam, surnameParam, new Pesel(peselParam), new Address(cityParam, streetParam, phoneParam), new Parent(parentNameParam, parentSurnameParam));

            patientsService.add(patient);

            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println("Pomyślnie dodano pacjenta: " + patient.toString() + "\n");
            resp.getWriter().println(patientsReadModel.getAll().getPatients());

        } catch (IOException | PeselException e) {
            e.printStackTrace();
            resp.getWriter().println(e.getMessage());
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
