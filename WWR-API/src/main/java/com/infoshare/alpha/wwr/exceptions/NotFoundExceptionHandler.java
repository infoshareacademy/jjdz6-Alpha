package com.infoshare.alpha.wwr.exceptions;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {

    @Inject
    Logger logger;

    @Override
    public Response toResponse(NotFoundException e) {
        logger.warn("NotFoundException has been thrown. StackTrace: ", e);
        return Response.status(Response.Status.NOT_FOUND)
                .entity("404 NOT FOUND")
                .build();
    }
}