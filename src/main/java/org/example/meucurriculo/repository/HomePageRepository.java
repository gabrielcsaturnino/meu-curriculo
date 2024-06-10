package org.example.meucurriculo.repository;

import org.example.meucurriculo.models.HomePage;
import org.example.meucurriculo.models.Project;

import java.util.List;

public interface HomePageRepository {
    void saveHomePage(HomePage homePage);
    HomePage getHomePage(String id);
    List<Project> getListProject();
}
