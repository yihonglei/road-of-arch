package com.jpeony.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 *
 * @author yihonglei
 */
public class JpeonyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // 过滤器里面做拦截操作等等
        System.out.println("jpeonyFilter的doFilter方法");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
