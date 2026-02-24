package com.example.flutter_api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "carteira")
public class Carteira {
    @Id
    @PrimaryKeyJoinColumn
    private String sigla;

    private String moeda;

    private String quantidade;


    //getters

    public String getSigla() {
        return sigla;
    }

    public String getMoeda() {
        return moeda;
    }

    public String getQtd() {
        return quantidade;
    }


    //setters

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public void setQtd(String quantidade) {
        this.quantidade = Carteira.this.quantidade;
    }

}
