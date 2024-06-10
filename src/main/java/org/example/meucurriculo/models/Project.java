package org.example.meucurriculo.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Project implements Serializable{

    private String id;
    private String nome;
    private String descricao;

    public Project(String id, String nome, String descricao){
       this.id = id;
       this.nome = nome;
       this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Project{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
