package com.jpeony.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yihonglei
 */
@WebListener
public class SessionListener implements HttpSessionListener, ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("userCounter", new AtomicInteger() + "");
        System.out.println("SessionListener.contextInitialized(ServletContextEvent sce)");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("SessionListener.contextDestroyed(ServletContextEvent sce)");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionListener.sessionCreated(HttpSessionEvent se)");
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");

        int userCount = userCounter.incrementAndGet();
        System.out.println("userCount incremented to :" + userCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SessionListener.sessionDestroyed(HttpSessionEvent se)");
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");

        int userCount = userCounter.decrementAndGet();
        System.out.println("---------- userCount decremented to:" + userCount);
    }

}
