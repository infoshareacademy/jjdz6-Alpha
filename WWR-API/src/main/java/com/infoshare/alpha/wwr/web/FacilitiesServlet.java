package com.infoshare.alpha.wwr.web;

import com.infoshare.alpha.wwr.domain.Facility;
import com.infoshare.alpha.wwr.exceptions.IdNotFoundException;
import com.infoshare.alpha.wwr.service.FacilitiesService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/facilities")
public class FacilitiesServlet {

    @Inject
    FacilitiesService facilitiesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFacilities() {
        return Response.ok()
                .entity(facilitiesService.getFacilitiesList())
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFacilityDetails(@PathParam("id") Long id) {
        Facility facilityById;
        try {
            facilityById = facilitiesService.getById(id);
        } catch (IdNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response.ok()
                .entity(facilityById)
                .build();
    }
}
