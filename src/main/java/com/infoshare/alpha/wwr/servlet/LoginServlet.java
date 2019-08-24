package com.infoshare.alpha.wwr.servlet;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshare.alpha.wwr.servlet.validators.IdTokenValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends BaseWwrServlet{

    private static final String ADMIN_PANEL_PATH = "/wwr/admin-panel" ;

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenValidator.getPayload(idToken);
            String name = (String) payLoad.get("name");

            req.getSession().setAttribute("userName", name);
            resp.sendRedirect(ADMIN_PANEL_PATH);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
