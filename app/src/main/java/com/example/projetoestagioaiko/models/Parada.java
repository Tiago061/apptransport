package com.example.projetoestagioaiko.models;

public class Parada {
    private int codigo;
    private String nome;

    public Parada(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
