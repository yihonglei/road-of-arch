package com.jpeony.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet实例会被一个应用程序中的所有用户共享，因此不建议使用类级变量，
 * 除非它们是只读的，或者是java.util.concurrent.atomic包的成员。
 * Servlet接口定义有5个方法。
 * <p>
 * 注解@WebServlet用来声明一个Servlet;
 * name用于定义Servlet名字，可以随便取;
 * urlPatterns定义用哪个URL来调用这个Servlet;
 * <p>
 * 注意: URL样式必须用一个正斜杠开头。
 *
 * @author yihonglei
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/myServlet"})
public class MyServlet implements Servlet {
    private transient ServletConfig servletConfig;

    /**
     * 当该第一次请求Servlet时，Servlet容器会调用init()方法，这个方法在后续请求中不会再被调用。
     * <p>
     * 我们可以使用这个方法执行初始化工作。调用这个方法时，Servlet容器会传入一个ServletConfig。
     * 一般来说，你会将ServletConfig赋给一个类变量，因此这个对象可以通过Servlet类的其他点来使用。
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("当该Servlet第一次请求时，Servlet容器调用init方法，并传入ServletConfig对象!");
        this.servletConfig = servletConfig;
    }

    /**
     * 这个方法会返回由Servlet容器传给init方法的ServletConfig，但是，为了让getServletConfig返回一个非null值，
     * 必须将传给init方法的ServletConfig赋给一个类级变量。
     */
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    /**
     * 每当请求Servlet时，Servlet容器就会调用这个方法，编写代码时，是假设Servlet要在这里被请求。
     * 第一次请求Servlet时，Servlet容器调用init方法和Service方法。
     * 后续的请求将只调用Service方法。
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("每次请求，都调用service方法!");
        String servletName = servletConfig.getServletName();
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head></head>"
                + "<body>Hello from " + servletName
                + "</body></html>");
    }

    /**
     * 这个方法会返回Servlet的描述。
     * 你可以返回有用或为null的任意字符串。
     */
    @Override
    public String getServletInfo() {
        return "My Servlet";
    }

    /**
     * 当要销毁Servlet时，Servlet容器就会调用这个方法。
     * 当要卸载应用程序，或者当要关闭Servlet容器时，就会发生这种情况。
     * 一般会在这个方法中编写清除代码。
     */
    @Override
    public void destroy() {
        System.out.println("清除代码");
    }
}
