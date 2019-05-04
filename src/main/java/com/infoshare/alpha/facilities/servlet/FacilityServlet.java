package com.infoshare.alpha.facilities.servlet;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityService;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
public class FacilityServlet extends HttpServlet{

    @Inject
    FacilityService facilityService;

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Facility servlet");
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

        resp.getWriter().println("Facility added successfully")
    }
}
