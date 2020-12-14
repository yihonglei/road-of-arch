package com.jpeony.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * name：定义Servlet名称
 * urlPatterns：Servlet请求的url
 * initParams：ServletConfig的初始化参数
 * <p>
 * GenericServlet中init使用模板方法初始ServletConfig，用户也可以选择实现init方法，对Servlet进行增强：
 * <p>
 * public void init(ServletConfig config) throws ServletException {
 * this.config = config;
 * this.init();
 * }
 * <p>
 * public void init() throws ServletException {
 * <p>
 * }
 *
 * @author yihonglei
 */
@WebServlet(name = "GenericServletDemoServlet",
        urlPatterns = {"/generic"},
        initParams = {
                @WebInitParam(name = "admin", value = "Harry Taciak"),
                @WebInitParam(name = "email", value = "admin@example.com"),
        }
)
public class GenericServletDemoServlet extends GenericServlet {

    private static final long serialVersionUID = -5999881252770234868L;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head></head><body>" +
                "Admin:" + admin +
                "<br/>Email:" + email +
                "</body></html>");
    }

}
