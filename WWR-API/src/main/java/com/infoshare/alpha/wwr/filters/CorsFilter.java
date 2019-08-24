package com.infoshare.alpha.wwr.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Collections;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.computeIfAbsent("Access-Control-Allow-Origin", v -> Collections.singletonList("http://127.0.0.1:8080"));
        headers.computeIfAbsent("Access-Control-Allow-Headers", v -> Collections.singletonList("Content-Type"));
        headers.computeIfAbsent("Access-Control-Allow-Methods", v -> Collections.singletonList("GET, POST"));
    }
}