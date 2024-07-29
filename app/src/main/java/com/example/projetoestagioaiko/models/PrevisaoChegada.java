package com.example.projetoestagioaiko.models;

import com.google.gson.annotations.SerializedName;

public class PrevisaoChegada {
    @SerializedName("linha")
    private String linha;

    @SerializedName("previsao")
    private String previsao;

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getPrevisao() {
        return previsao;
    }

    public void setPrevisao(String previsao) {
        this.previsao = previsao;
    }
}

