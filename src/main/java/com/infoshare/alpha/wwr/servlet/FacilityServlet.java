package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.domain.facilities.FacilitiesService;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityAddCommand;
import com.infoshare.alpha.wwr.domain.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
public class FacilityServlet extends BaseWwrServlet {

    @Inject
    private FacilitiesService facilitiesService;
    @Inject
    private FacilitiesReadModel facilitiesReadModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        facilitiesReadModel.getAll().getFacilities()
                .forEach(facility -> {
                    try {
                        resp.getWriter().println(facility);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        Facility newFacility = new Facility("test", new Address("test", "test", "test"), new ArrayList<Service>());

        try {
            facilitiesService.add(new FacilityAddCommand(newFacility));
        } catch (FacilitiesException e) {
            e.printStackTrace();
        }

        facilitiesReadModel.getAll().getFacilities()
                .forEach(facility -> {
                    try {
                        resp.getWriter().println(facility);
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
