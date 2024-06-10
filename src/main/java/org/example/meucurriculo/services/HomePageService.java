package org.example.meucurriculo.services;

import org.example.meucurriculo.models.HomePage;
import org.example.meucurriculo.models.Project;
import org.example.meucurriculo.repositoryimpl.HomePageRepositoryImpl;

public class HomePageService {
    HomePageRepositoryImpl homePageRepositoryImpl;
    ProjectService projectService;

    public HomePageService() {
        this.homePageRepositoryImpl = new HomePageRepositoryImpl();
    }

    public void saveHomePage(HomePage homePage){
        homePageRepositoryImpl.saveHomePage(homePage);
    }

    public HomePage getHomePage(String id){
        HomePage homePage = homePageRepositoryImpl.getHomePage(id);
        if(homePage == null){
            homePage = new HomePage("Apresentacao", "rede_social", "nome", "email");
            saveHomePage(homePage);
        }
        return homePage;
    }

    public void addProjectToHomePage(String id, Project project){
        HomePage homePage = getHomePage(id);
        homePage.addProject(project);
        saveHomePage(homePage);
    }
}
