package org.example.meucurriculo.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter @Setter
public class HomePage implements Serializable {
    private String apresentacao;
    private String nome;
    private String email;
    private String rede_social;
    private ArrayList<Project> list_project = new ArrayList<>();


    public HomePage(){
    }
    public HomePage(String apresentacao, String rede_social, String nome, String email){
        this.apresentacao = apresentacao;
        this.rede_social = rede_social;
        this.nome = nome;
        this.email = email;
    }

    public void addProject(Project project){
        list_project.add(project);
    }

    public void getProject(){
        if(list_project.size() > 0){
            for(Project p : list_project){
                System.out.println(p);
            }
        }else{
            System.out.println("Nenhum project encontrado");
        }
    }
}
