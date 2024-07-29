package com.example.projetoestagioaiko.models;

import com.google.gson.annotations.SerializedName;

public class LinhaOnibus {
    @SerializedName("numero")
    private String numero;
    @SerializedName("nome")
    private String nome;

    public LinhaOnibus(String numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
