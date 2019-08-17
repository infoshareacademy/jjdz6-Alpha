package com.infoshare.alpha.wwr.web;

import com.infoshare.alpha.wwr.service.ArchivedFacilitiesService;
import com.infoshare.alpha.wwr.service.FacilitiesService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/facilities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacilitiesServlet {

    @Inject
    FacilitiesService facilitiesService;

    @Inject
    ArchivedFacilitiesService facilityDetailsArchiveService;

    @GET
    public Response getFacilities() {
        return Response.status(Response.Status.OK)
                .entity(facilitiesService.getFacilitiesList())
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getFacilityDetails(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                .entity(facilitiesService.getById(id))
                .build();
    }

    @GET
    @Path("/archived-details")
    public Response getFacilitiesArchiveDetails() {
        return Response.status(Response.Status.OK)
                .entity(facilityDetailsArchiveService.getArchivedFacilities())
                .build();
    }

//    TODO
//    @POST
//    @Path("/archived-details")
//    public Response addFacilityToArchive(@Valid Facility facility) {
//        return Response.status(Response.Status.CREATED)
//                .entity(facilityDetailsArchiveService.addArchivedFacility(facility))
//                .build();
//    }

//    TODO
//    @GET
//    @Path("/{id}/archived-details")
//    public Response getFacilityArchiveDetailsByFacilityId(@PathParam("id") int id) {
//        return Response.status(Response.Status.OK)
//                .entity(facilityDetailsArchiveService.getArchivedFacilitiesByFacilityId(id))
//                .build();
//    }

//    TODO - facilities by date for provided id
//    @GET
//    @Path("/{id}/archived-details/{date: \\d{4}-\\d{2}-\\d{2}}")
//    public Response getFacilityArchiveDetailsByDate(@PathParam("id") int id, @PathParam("date") String date) {
//        return Response.status(Response.Status.OK)
//                .entity(facilityDetailsArchiveService.getArchivedFacilityByDate(LocalDate.parse(date)))
//                .build();
//    }
}
