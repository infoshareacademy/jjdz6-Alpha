package com.infoshare.alpha.wwr.web;

import com.infoshare.alpha.wwr.service.SearchBarQueriesService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/queries")
public class SearchBarQueriesServlet {

    @Inject
    SearchBarQueriesService searchBarQueriesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQueries() {
        return Response.ok()
                .entity(searchBarQueriesService.getSearchBarQueriesList())
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQueryDetails(@PathParam("id") int id) {
        return Response.ok()
                .entity(searchBarQueriesService.getById(id))
                .build();
    }
}
