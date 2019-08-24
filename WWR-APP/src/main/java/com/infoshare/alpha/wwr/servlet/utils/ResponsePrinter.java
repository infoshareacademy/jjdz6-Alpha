package com.infoshare.alpha.wwr.servlet.utils;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequestScoped
public class ResponsePrinter {

    public void print(HttpServletResponse response, String data) throws IOException {
        PrintWriter out = response.getWriter();
        out.println(data);
        out.flush();
    }

}
