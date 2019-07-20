package com.infoshare.alpha.wwr.servlet;

import com.infoshare.alpha.wwr.domain.Facility;
import com.infoshare.alpha.wwr.exceptions.FacilityNotFoundException;
import com.infoshare.alpha.wwr.service.FacilitiesService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/find-facilities-tracker")
public class PatientsFacilitiesSearchTracker {

    @Inject
    FacilitiesService facilitiesService;

    @GET
    @Path("/facility/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFacilitiesNumberOfOccurrences(@PathParam("id") Long id) {
        Facility selectedFacility;
        try {
            selectedFacility = facilitiesService.getById(id);
        } catch (FacilityNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response.ok()
                .entity(selectedFacility)
                .build();
    }
}
