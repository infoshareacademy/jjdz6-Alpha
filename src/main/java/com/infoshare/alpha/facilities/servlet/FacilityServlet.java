package com.infoshare.alpha.facilities.servlet;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"}, initParams={
        @WebInitParam(name="name", value="Not provided"),
        @WebInitParam(name="email", value="Not provided")})
public class FacilityServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    	// mvn dependency:resolve -> get external packages to .m2
    	// from web.xml props.
        resp.getWriter().println("Facility servlet");
        ServletConfig sc = this.getServletConfig();

        //resp.getWriter().println(sc.getInitParameter("name"));
        //resp.getWriter().println("name : " + getRequestParameter(req,"name"));
        //resp.getWriter().println("email : " + getRequestParameter(req,"email"));
        
        // system properties set -> http://127.0.0.1:9990/console/index.html#system-properties
        /*
        resp.getWriter().println("wwr.repo.path : " + System.getProperties().getProperty("wwr.repo.path"));

        Properties prop = System.getProperties();
        Set<Object> keySet = prop.keySet();
        for(Object obj : keySet){
        	resp.getWriter().println("System Property: {"+obj.toString()+","+System.getProperty(obj.toString())+"}");
        }
        */
    }

    protected String getRequestParameter(
            HttpServletRequest request,
            String name) {
        String param = request.getParameter(name);
        return !param.isEmpty() ? param : getInitParameter(name);
    }
}
