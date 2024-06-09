package org.example.meucurriculo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.meucurriculo.models.HomePage;
import org.example.meucurriculo.services.HomePageService;
import java.io.IOException;

@WebServlet("/formApresentation")
public class InsertHomePageServlet extends HttpServlet {
    HomePageService homePageService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entrou post");
        if(req.getSession().getAttribute("authenticated") !=null){
            System.out.println("entrou post if");
            homePageService = new HomePageService();
            String apresentacao = req.getParameter("apresentacao");
            String nome = req.getParameter("nome");
            String rede_social = req.getParameter("rede_social");
            String email = req.getParameter("email");
            homePageService.saveHomePage(new HomePage(apresentacao, rede_social, nome, email));
            resp.sendRedirect(req.getContextPath() + "/");

        }else{
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
