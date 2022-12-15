package org.seven.imageservlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CalendarFeederFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void destroy() {

    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
	}
}
