package com.jpeony.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yihonglei
 */
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1169263687746725411L;

    /**
     * 重写doGet()方法，处理Get请求
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<html><head><body>Welcome, baby!</body></head></html>");
    }
}
