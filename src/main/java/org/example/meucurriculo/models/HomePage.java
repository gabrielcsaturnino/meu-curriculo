package org.example.meucurriculo.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class HomePage implements Serializable {
    public String apresentacao;
    public String numero;
    public String nome;
    public String email;

    public HomePage(){
    }
    public HomePage(String apresentacao, String numero, String nome, String email) {
        this.apresentacao = apresentacao;
        this.numero = numero;
        this.nome = nome;
        this.email = email;
    }

    public HomePage(String apresentacao){
        this.apresentacao = apresentacao;
    }
}
