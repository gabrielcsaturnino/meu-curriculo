package org.example.meucurriculo.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.meucurriculo.models.Project;
import org.example.meucurriculo.repositoryimpl.ProjectRepositoryImpl;


public class ProjectService {
    ProjectRepositoryImpl projectRepository;


    public void saveProject(Project project){
        projectRepository = new ProjectRepositoryImpl();
        projectRepository.saveProject(checkNameLength(project));

    }

    public Project checkNameLength(Project project) {
        if(project.getNome().length()<=254){
            return project;
        }else {
            project.setNome(project.getNome().substring(0, 254));
            return project;
        }
    }
}
