package com.example.lista_de_alunos.model;

import java.io.Serializable;

public class Aluno implements Serializable {
    private String nome;
    private String sobrenome;
    private String matricula;
    private String curso;
    private Integer ano;
    public Aluno(String nome, String sobrenome, String matricula, String curso, Integer ano) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.curso = curso;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getCurso() { return curso; }
    public Integer getAno() { return ano; }

    @Override
    public String toString() {
        return matricula + " - " + nome;
    }
}
