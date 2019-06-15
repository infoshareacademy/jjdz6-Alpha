package com.infoshare.alpha.wwr.servlet;

import com.google.gson.Gson;
import com.infoshare.alpha.wwr.utils.ResponsePrinter;
import com.infoshare.alpha.wwr.servlet.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public abstract class BaseWwrServlet extends HttpServlet {

    protected Gson gson = new Gson();

    protected final Logger logger = Logger.getLogger(this.getClass().getName());

    protected HttpServletResponse response;

    @Inject
    protected ResponsePrinter responsePrinter;

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        if (req.getMethod().equalsIgnoreCase("PATCH")) {
            doPatch(req, resp);
        } else if(req.getMethod().equalsIgnoreCase("POST") &&  req.getParameter("_method").equalsIgnoreCase("PUT")) {
            doPut(req, resp);
        } else {
            super.service(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.response = this.setResponseHeaders(resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.response = this.setResponseHeaders(resp);
    }

    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = ResourceBundle.getBundle("javax.servlet.http.LocalStrings").getString("http.method_patch_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }
    }

    protected HttpServletResponse setResponseHeaders(HttpServletResponse response) {
        response.setHeader("Content-type", "text/html");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.setCharacterEncoding("UTF-8");

        return response;
    }

    protected void renderView(Object model, String templatePath) throws IOException {
        try {
            Template template = templateProvider.getTemplate(getServletContext(), templatePath);
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            throw new IOException(e.getMessage());
        }
    }

    protected void renderJson(Object model) throws IOException {
        response.setHeader("Content-type", "application/json");
        response.setContentType("application/json");
        responsePrinter.print(response, gson.toJson(model));
    }

    protected void logError(String msg, int code) {
        logger.severe("Error: " + msg);
        logger.severe("Error code: " + code);
    }
}
