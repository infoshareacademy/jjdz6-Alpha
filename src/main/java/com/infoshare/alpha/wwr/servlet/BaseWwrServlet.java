package com.infoshare.alpha.wwr.servlet;

import com.google.gson.Gson;
import com.infoshare.alpha.wwr.utils.Config;
import com.infoshare.alpha.wwr.utils.ResponsePrinter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public abstract class BaseWwrServlet extends HttpServlet {

    protected Gson gson = new Gson();

    @Inject
    protected ResponsePrinter responsePrinter;

    @Inject
    protected Config config;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("PATCH")) {
            doPatch(req, resp);
        } else {
            super.service(req, resp);
        }
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
        response.setHeader("Content-type", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with ");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        return response;
    }
}
