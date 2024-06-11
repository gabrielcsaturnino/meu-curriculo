package org.example.meucurriculo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.meucurriculo.models.Project;
import org.example.meucurriculo.services.HomePageService;
import org.example.meucurriculo.services.ProjectService;

import java.io.IOException;
import java.util.ArrayList;


public class ReturnProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomePageService homePageService = new HomePageService();
        ArrayList<Project> projectList = homePageService.getHomePage("homePage").getProject();
        req.setAttribute("projectList", projectList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
