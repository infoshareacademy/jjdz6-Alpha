package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.domain.facilities.FacilitiesService;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityAddCommand;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
public class FacilityServlet extends BaseWwrServlet {

    @Inject
    FacilitiesService facilitiesService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = req.getParameter("name");
        String address = req.getParameter("street");
        String city = req.getParameter("city");
        String phone = req.getParameter("phone");
        String postalCode = req.getParameter("postalCode");
        Boolean isNfz = Boolean.valueOf(req.getParameter("isNfz"));

        FacilityAddCommand facility = new FacilityAddCommand(name, city,phone, address, postalCode, isNfz);

        facilitiesService.add(facility);

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
