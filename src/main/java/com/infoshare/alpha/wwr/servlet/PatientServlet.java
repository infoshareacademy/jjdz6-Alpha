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
    private PatientsService patientsService;
    @Inject
    private PatientsReadModel patientsReadModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        patientsReadModel.getAll().getPatients()
                .forEach(patient -> {
                    try {
                        resp.getWriter().println(patient);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        try {
            Patient newPatient = new Patient("test", "test", new Pesel("00000000000"), new Address("test", "test", "test"), new Parent("test", "test"));
            patientsService.add(newPatient);
        } catch (PeselException e) {
            e.printStackTrace();
        }

        patientsReadModel.getAll().getPatients()
                .forEach(patient -> {
                    try {
                        resp.getWriter().println(patient);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
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
