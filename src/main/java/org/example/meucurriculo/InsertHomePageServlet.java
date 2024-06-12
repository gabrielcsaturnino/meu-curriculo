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
    HomePage homePage;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("authenticated") !=null){

            homePageService = new HomePageService();
            String apresentacao = req.getParameter("apresentacao");
            String nome = req.getParameter("nome");
            String rede_social = req.getParameter("rede_social");
            String email = req.getParameter("email");
            if(homePageService.getHomePage("homePage") != null) {
                homePage.setApresentacao(apresentacao);
                homePage.setNome(nome);
                homePage.setRede_social(rede_social);
                homePage.setEmail(email);
                homePage.setList_project(homePageService.getHomePage("homePage").getList_project());
                homePageService.saveHomePage(homePage);
            }else {
                homePageService.saveHomePage(new HomePage(apresentacao, rede_social, nome, email));
            }
            resp.sendRedirect(req.getContextPath() + "/");

        }else{
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
