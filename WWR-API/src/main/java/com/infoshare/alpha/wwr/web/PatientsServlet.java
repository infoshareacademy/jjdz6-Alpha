package com.infoshare.alpha.wwr.web;

import com.infoshare.alpha.wwr.service.PatientsService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/patients")
public class PatientsServlet {

    @Inject
    PatientsService patientsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatients() {
        return Response.ok()
                .entity(patientsService.getPatientsList())
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientDetails(@PathParam("id") int id) {
        return Response.ok()
                .entity(patientsService.getById(id))
                .build();
    }
}
