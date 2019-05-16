package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.utils.ErrorResponse;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
public class FacilityServlet extends BaseWwrServlet {

    @Inject
    FacilitiesReadModel facilitiesReadModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpServletResponse response = this.setResponseHeaders(resp);

        try {
            String id = req.getParameter("id");
            config.register(this.getServletContext());

            if (null == id) {
                throw new IOException("Id param missing.");
            }

            Facility facility = facilitiesReadModel.getById(Integer.valueOf(id));

            if (null == facility) {
                throw new IOException("Facility id: " + id + " not found.");
            }

            response.setStatus(HttpServletResponse.SC_OK);
            responsePrinter.print(response, gson.toJson(facility));

        } catch (IOException e) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responsePrinter.print(response, gson.toJson(new ErrorResponse(e.getMessage(), HttpServletResponse.SC_BAD_REQUEST)));
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
