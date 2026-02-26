package com.example.flutter_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "favoritas")
public class Favoritas {
    private String icone;
    private String nome;
    @Id
    private String sigla;
    private String valor;


    public Favoritas() {
    }

    public Favoritas(String icone, String nome, String sigla, String valor) {
        this.icone = icone;
        this.nome = nome;
        this.sigla = sigla;
        this.valor = valor;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
