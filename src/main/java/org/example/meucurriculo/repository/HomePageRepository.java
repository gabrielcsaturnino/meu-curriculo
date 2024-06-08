package org.example.meucurriculo.repository;

import org.example.meucurriculo.models.HomePage;

public interface HomePageRepository {
    void saveHomePage(HomePage homePage);
    HomePage getHomePage(String id);
}
