package org.example.meucurriculo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/processLogin")
public class LoginProcessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("username").equals("admin") && req.getParameter("password").equals("admin")) {
            HttpSession session = req.getSession();
            session.setAttribute("authenticated", true);
            session.setMaxInactiveInterval(60);
            resp.sendRedirect(req.getContextPath() + "/restricted/dashboard-admin.jsp");
        }else{
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("authenticated") != null) {
            resp.sendRedirect(req.getContextPath() + "/restricted/dashboard-admin.jsp");
        }
    }
}
