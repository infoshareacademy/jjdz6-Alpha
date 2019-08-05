package com.infoshare.alpha.wwr.exceptions;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundExceptionHandler implements ExceptionMapper<ResourceNotFoundException> {

    @Inject
    Logger logger;

    @Override
    public Response toResponse(ResourceNotFoundException e) {
        logger.warn("ResourceNotFoundException has been thrown.");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .build();
    }
}
