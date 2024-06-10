package org.example.meucurriculo;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.meucurriculo.models.HomePage;
import org.example.meucurriculo.models.Project;
import org.example.meucurriculo.services.HomePageService;
import org.example.meucurriculo.services.ProjectService;


import java.io.IOException;

@WebServlet("/insertProject")
public class InsertProjectServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("authenticated") != null) {
            String id = "1";
            String nome =  req.getParameter("nome");
            String descricao = req.getParameter("descricao");

            if(nome.isEmpty() && descricao.isEmpty()) {
                req.getSession().setAttribute("error", "valor nulo");
                resp.sendRedirect(req.getContextPath() + "/restricted/dashboard-admin.jsp");
            }else {
                HomePageService homePageService = new HomePageService();
                homePageService.addProjectToHomePage("homePage", new Project(id, nome, descricao));
                homePageService.getHomePage("homePage").getProject();
                resp.sendRedirect(req.getContextPath() + "/");
            }
        }else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }

   
     

    }
}
