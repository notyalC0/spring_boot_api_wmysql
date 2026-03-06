package com.example.flutter_api.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "moedas")
public class Moeda {

    @Id
    String sigla;

    String nome;
    String icone;
    double valor;

    public Moeda() {
    }

    public Moeda(String sigla, String nome, String icone, double valor) {
        this.sigla = sigla;
        this.nome = nome;
        this.icone = icone;
        this.valor = valor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
