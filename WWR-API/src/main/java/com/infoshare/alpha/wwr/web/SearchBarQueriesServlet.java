package com.infoshare.alpha.wwr.web;

import com.infoshare.alpha.wwr.domain.SearchBarQuery;
import com.infoshare.alpha.wwr.service.SearchBarQueriesService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @POST
    public Response addQuery(@Valid SearchBarQuery searchBarQuery) {
        return Response.status(Response.Status.CREATED)
                .entity(searchBarQueriesService.saveSearchBarQuery(searchBarQuery))
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getQueryDetails(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                .entity(searchBarQueriesService.getById(id))
                .build();
    }
}
