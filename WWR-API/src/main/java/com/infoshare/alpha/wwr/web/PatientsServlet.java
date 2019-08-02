package com.infoshare.alpha.wwr.web;

import com.infoshare.alpha.wwr.domain.Patient;
import com.infoshare.alpha.wwr.exceptions.IdNotFoundException;
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
    public Response getPatientDetails(@PathParam("id") Long id) {
        Patient patientById;
        try {
            patientById = patientsService.getById(id);
        } catch (IdNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response.ok()
                .entity(patientById)
                .build();
    }
}
