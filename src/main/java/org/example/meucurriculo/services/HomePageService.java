package org.example.meucurriculo.services;

import org.example.meucurriculo.models.HomePage;
import org.example.meucurriculo.repositoryimpl.HomePageRepositoryImpl;

public class HomePageService {
    HomePageRepositoryImpl homePageRepositoryImpl;

    public void saveHomePage(HomePage homePage){
        homePageRepositoryImpl = new HomePageRepositoryImpl();
        homePageRepositoryImpl.saveHomePage(homePage);
    }
}
