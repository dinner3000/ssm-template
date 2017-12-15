package com.dinner3000.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter - init()");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter - doFilter() - before");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MyFilter - doFilter() - after");
    }

    public void destroy() {
        System.out.println("MyFilter - destroy()");
    }
}
