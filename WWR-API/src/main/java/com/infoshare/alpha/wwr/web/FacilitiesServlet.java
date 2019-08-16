package com.infoshare.alpha.wwr.web;


import com.infoshare.alpha.wwr.entities.Facility;
import com.infoshare.alpha.wwr.service.FacilitiesService;
import com.infoshare.alpha.wwr.service.FacilityDetailsArchiveService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/facilities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacilitiesServlet {

    //facilities @GET
    //facilities/{id} @GET
    //facilities/{id}/archived-details @GET, @POST
    //facilities/{id}/archived-details/{id} <- index?
    //facilities/{id}/archived-details/{id}/{date}

    //changes
    //changes/{id}
    //changes/{date}
    //changes/facilities
    //changes/facilities/{id}
    //changes/facilities/{date}
    //changes/patients...

    @Inject
    FacilitiesService facilitiesService;

    @Inject
    FacilityDetailsArchiveService facilityDetailsArchiveService;

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
                .entity(facilityDetailsArchiveService.getArchivedFacilityDetailsList())
                .build();
    }

    @POST
    @Path("/archived-details")
    public Response addFacilityDetailsToArchive(@Valid Facility facility) {
        return Response.status(Response.Status.CREATED)
                .entity(facilityDetailsArchiveService.addFacilityDetails(facility))
                .build();
    }

    @GET
    @Path("/{id}/archived-details")
    public Response getFacilityArchiveDetailsByFacilityId(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                .entity(facilityDetailsArchiveService.getArchivedFacilityDetailsByFacilityId(id))
                .build();
    }

//    @GET
//    @Path("/{id}/archived-details/{index}")
//    public Response getFacilityArchiveDetails(@PathParam("id") int id, @PathParam("index") int index) {
//        List<FacilityDetailsArchive> archivedFacilityDetailsByFacilityId = facilityDetailsArchiveService.getArchivedFacilityDetailsByFacilityId(id);
//        FacilityDetailsArchive facilityDetailsArchiveResult = archivedFacilityDetailsByFacilityId.get(index);
//        return Response.status(Response.Status.OK)
//                .entity(facilityDetailsArchiveResult)
//                .build();
//    }

    @GET
    @Path("/{id}/archived-details/{date: \\d{4}-\\d{2}-\\d{2}}")
    public Response getFacilityArchiveDetailsByDate(@PathParam("id") int id, @PathParam("date") String date) {
        return Response.status(Response.Status.OK)
                .entity(facilityDetailsArchiveService.getArchivedFacilityDetailsByDate(LocalDate.parse(date)))
                .build();
    }
}
