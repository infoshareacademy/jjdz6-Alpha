package com.infoshare.alpha.wwr.servlet;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshare.alpha.wwr.servlet.validators.IdTokenValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends BaseWwrServlet{

    private final String LOGIN_TEMPLATE_PATH = "/login.ftlh";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        Map<String, Object> model = new HashMap<>();
        renderView(model, LOGIN_TEMPLATE_PATH);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenValidator.getPayload(idToken);
            String name = (String) payLoad.get("name");

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);
            req.getServletContext()
                    .getRequestDispatcher("/admin-panel").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
