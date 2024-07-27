package com.example.projetoestagioaiko.models;

import java.util.List;

public class PosicaoResponse {
    private List<Veiculo> l;

    public List<Veiculo> getL(){
        return l;
    }
    public void setL(List<Veiculo> l){
        this.l = l;
    }

    public static class Veiculo{
        private int p;
        private String a;
        private double px;
        private double py;

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public double getPx() {
            return px;
        }

        public void setPx(double px) {
            this.px = px;
        }

        public double getPy() {
            return py;
        }

        public void setPy(double py) {
            this.py = py;
        }
    }
}
