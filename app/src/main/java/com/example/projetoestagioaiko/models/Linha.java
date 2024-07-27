package com.example.projetoestagioaiko.models;

public class Linha {
    private String codigo;
    private String nome;

    public Linha(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

}
