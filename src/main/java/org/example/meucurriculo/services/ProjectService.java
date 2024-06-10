package org.example.meucurriculo.services;


import org.example.meucurriculo.models.Project;



public class ProjectService {

    public Project checkNameLength(Project project) {
        if(project.getNome().length()<=254){
            return project;
        }else {
            project.setNome(project.getNome().substring(0, 254));
            return project;
        }
    }


}
