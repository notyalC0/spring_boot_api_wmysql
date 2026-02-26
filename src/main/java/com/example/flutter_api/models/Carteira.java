package com.example.flutter_api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "carteira")
public class Carteira {

    @Id
    private String sigla;

    private String moeda;

    private String quantidade;

    public Carteira() {
    }

    public Carteira(String sigla, String moeda, String quantidade) {
        this.sigla = sigla;
        this.moeda = moeda;
        this.quantidade = quantidade;
    }
//getters

    public String getSigla() {
        return sigla;
    }

    public String getMoeda() {
        return moeda;
    }

    public String getQuantidade() {
        return quantidade;
    }


    //setters

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

}
