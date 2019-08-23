package com.infoshare.alpha.wwr.servlet;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshare.alpha.wwr.servlet.validators.IdTokenValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginServlet", urlPatterns = {"/wwr/login"})
public class LoginServlet extends BaseWwrServlet{


    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenValidator.getPayload(idToken);
            String name = (String) payLoad.get("name");

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);

//            req.getServletContext().getRequestDispatcher("/wwr/admin-panel").forward(req, resp);
            resp.sendRedirect("/wwr/admin-panel");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
