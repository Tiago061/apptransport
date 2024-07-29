package com.example.projetoestagioaiko.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PontosDeParadaResponse {
    @SerializedName("pontos")
    private List<PontoDeParada> pontos;

    public List<PontoDeParada> getPontos() {
        return pontos;
    }

    public void setPontos(List<PontoDeParada> pontos) {
        this.pontos = pontos;
    }
}
