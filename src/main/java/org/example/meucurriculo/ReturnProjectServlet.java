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
     HomePageService homePageService = new HomePageService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Project> projectList = homePageService.getHomePage("homePage").getList_project();
        req.setAttribute("projectList", projectList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
