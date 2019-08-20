package com.infoshare.alpha.wwr.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AdminPanelServlet", urlPatterns = {"/admin-panel"})
public class AdminPanelServlet extends BaseWwrServlet{

    private final String ADMIN_PANEL_TEMPLATE_PATH = "/admin-panel.ftlh";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        Map<String, Object> model = new HashMap<>();
        renderView(model, ADMIN_PANEL_TEMPLATE_PATH);
    }
}
