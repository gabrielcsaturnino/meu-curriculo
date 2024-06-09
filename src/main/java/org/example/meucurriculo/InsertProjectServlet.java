package org.example.meucurriculo;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.meucurriculo.models.Project;
import org.example.meucurriculo.services.ProjectService;


import java.io.IOException;

@WebServlet("/insertProject")
public class InsertProjectServlet extends HttpServlet {



    ProjectService projectService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("authenticated") != null) {
            projectService = new ProjectService();

            String id = "1";
            String nome =  req.getParameter("nome");
            String descricao = req.getParameter("descricao");

            if(nome.equals("") && descricao.equals("")) {
                req.getSession().setAttribute("error", "valor nulo");
                resp.sendRedirect(req.getContextPath() + "/restricted/dashboard-admin.jsp");
            }else {
                projectService.saveProject(new Project(id, nome, descricao));
                resp.sendRedirect(req.getContextPath() + "/");
            }
        }else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }

   
     

    }
}
