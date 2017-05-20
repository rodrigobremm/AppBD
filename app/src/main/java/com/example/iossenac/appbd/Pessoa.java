package com.example.iossenac.appbd;

/**
 * Created by iossenac on 20/05/17.
 */

public class Pessoa {
    private String matricula;
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(String matricula, String nome, String telefone, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
