package org.example.meucurriculo.services;

import org.example.meucurriculo.models.HomePage;
import org.example.meucurriculo.repositoryimpl.HomePageRepositoryImpl;
import org.example.meucurriculo.repositoryimpl.ProjectRepositoryImpl;

public class HomePageService {
    HomePageRepositoryImpl homePageRepositoryImpl;

    public void saveHomePage(HomePage homePage){
        homePageRepositoryImpl = new HomePageRepositoryImpl();
        homePageRepositoryImpl.saveHomePage(homePage);
    }

    public HomePage getHomePage(String id){
        homePageRepositoryImpl = new HomePageRepositoryImpl();
        if(homePageRepositoryImpl.getHomePage(id) != null){
            return homePageRepositoryImpl.getHomePage(id);
        }else {
            saveHomePage(new HomePage("Apresentacao", "rede_social", "nome", "email" ));
            return homePageRepositoryImpl.getHomePage(id);
        }
    }
}
