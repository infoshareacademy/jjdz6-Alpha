package com.infoshare.alpha.wwr.utils;

import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletContext;

@RequestScoped
public class Config {

    private ServletContext servletContext;

    public void register(ServletContext context) {
        this.servletContext = context;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

}
