package com.hnist.servelet;

import javax.servlet.*;
import java.io.IOException;

public class FirstServelet implements Servlet {
    @Override
    /**
     * 最关键的方法
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("FirstServlet runing ...");
        servletResponse.getWriter().write("This is a Servlet");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //1.获得servlet的name-----<servlet-name>abc<>
        System.out.println("FirstServlet init....");
    }
    @Override
    public void destroy() {
        System.out.println("Servlet Destroy ...");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public String getServletInfo() {
        return null;
    }


}
