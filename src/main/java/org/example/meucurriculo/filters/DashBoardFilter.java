package org.example.meucurriculo.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter("/restricted/*")
public class DashBoardFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if(session.getAttribute("authenticated") != null) {
            chain.doFilter(request, response);
        }else{
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
