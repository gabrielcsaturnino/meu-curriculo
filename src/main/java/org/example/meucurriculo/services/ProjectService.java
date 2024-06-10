package org.example.meucurriculo.services;


import org.example.meucurriculo.models.Project;
import org.example.meucurriculo.repositoryimpl.ProjectRepositoryImpl;


public class ProjectService {
    ProjectRepositoryImpl projectRepositoryImpl;


    public void saveProject(Project project){
        projectRepositoryImpl = new ProjectRepositoryImpl();
        projectRepositoryImpl.saveProject(checkNameLength(project));

    }

    public Project checkNameLength(Project project) {
        if(project.getNome().length()<=254){
            return project;
        }else {
            project.setNome(project.getNome().substring(0, 254));
            return project;
        }
    }

    public Project getProject(String id) {
        if (projectRepositoryImpl.getProject(id) != null) {
            return projectRepositoryImpl.getProject(id);
        }else {
            saveProject(new Project("1", "nome", "descricao"));
            return projectRepositoryImpl.getProject(id);
        }
    }
}
