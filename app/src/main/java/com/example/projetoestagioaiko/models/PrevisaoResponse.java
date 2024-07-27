package com.example.projetoestagioaiko.models;

import java.util.List;

public class PrevisaoResponse {
    private List<Previsao> p;

    public List<Previsao> getP(){
        return p;
    }
    public void setP(List<Previsao> p){
        this.p = p;
    }

    public static class Previsao {
        private int CodigoLinha;
        private String NomeLinha;
        private String TipoLinha;
        private int codigoVeiculo;
        private double previsaoChegada;

        public int getCodigoLinha() {
            return CodigoLinha;
        }

        public void setCodigoLinha(int codigoLinha) {
            CodigoLinha = codigoLinha;
        }

        public String getNomeLinha() {
            return NomeLinha;
        }

        public void setNomeLinha(String nomeLinha) {
            NomeLinha = nomeLinha;
        }

        public String getTipoLinha() {
            return TipoLinha;
        }

        public void setTipoLinha(String tipoLinha) {
            TipoLinha = tipoLinha;
        }

        public int getCodigoVeiculo() {
            return codigoVeiculo;
        }

        public void setCodigoVeiculo(int codigoVeiculo) {
            this.codigoVeiculo = codigoVeiculo;
        }

        public double getPrevisaoChegada() {
            return previsaoChegada;
        }

        public void setPrevisaoChegada(double previsaoChegada) {
            this.previsaoChegada = previsaoChegada;
        }
    }
}
