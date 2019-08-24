package com.infoshare.alpha.wwr.web;

import com.infoshare.alpha.wwr.entity.SearchBarQuery;
import com.infoshare.alpha.wwr.service.SearchBarQueriesService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/queries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SearchBarQueriesServlet {

    @Inject
    SearchBarQueriesService searchBarQueriesService;

    @GET
    public Response getQueries() {
        return Response.status(Response.Status.OK)
                .entity(searchBarQueriesService.getSearchBarQueriesList())
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getQueryById(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK)
                .entity(searchBarQueriesService.getById(id))
                .build();
    }

    @GET
    @Path("{date: \\d{4}-\\d{2}-\\d{2}}")
    public Response getQueryByDate(@PathParam("date") String date) {
        return Response.status(Response.Status.OK)
                .entity(searchBarQueriesService.getByDate(LocalDate.parse(date)))
                .build();
    }

    @POST
    public Response addQuery(@Valid SearchBarQuery searchBarQuery) {
        return Response.status(Response.Status.CREATED)
                .entity(searchBarQueriesService.saveSearchBarQuery(searchBarQuery))
                .build();
    }
}
