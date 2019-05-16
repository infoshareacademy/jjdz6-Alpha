package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityService;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
public class FacilityServlet extends BaseWwrServlet {

    @Inject
    FacilityService facilityService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Facility facility = new Facility();
        Address address = new Address();

        facility.setName(String.valueOf(req.getParameter("name")));
        address.setStreet(String.valueOf(req.getParameter("street")));
        address.setCity(String.valueOf(req.getParameter("city")));
        address.setPhone(String.valueOf(req.getParameter("phone")));


        facilityService.saveFacility(facility);

        resp.getWriter().println("Facility added successfully");
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
