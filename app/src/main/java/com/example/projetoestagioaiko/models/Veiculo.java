package com.example.projetoestagioaiko.models;

import com.google.gson.annotations.SerializedName;

public class Veiculo {
    private String prefixo;
    private double px; // latitude
    private double py; // longitude
    private String a;  // indicador de acessibilidade
    private String t;  // horário da última atualização

    // Getters e setters

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public double getLatitude() {
        return px;
    }

    public void setLatitude(double latitude) {
        this.px = latitude;
    }

    public double getLongitude() {
        return py;
    }

    public void setLongitude(double longitude) {
        this.py = longitude;
    }

    public String getAcessibilidade() {
        return a;
    }

    public void setAcessibilidade(String acessibilidade) {
        this.a = acessibilidade;
    }

    public String getHorarioAtualizacao() {
        return t;
    }

    public void setHorarioAtualizacao(String horarioAtualizacao) {
        this.t = horarioAtualizacao;
    }
}
