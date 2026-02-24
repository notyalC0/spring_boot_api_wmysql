package com.example.flutter_api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "historico")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer data_operacao;

    private String tipo_operacao;

    private String moeda;

    private String sigla;

    private String valor;

    private String quantidade;

    // getters

    public Long getId() {
        return id;
    }

    public Integer getDataOp() {
        return data_operacao;
    }

    public String getTipoOp() {
        return tipo_operacao;
    }

    public String getMoeda() {
        return moeda;
    }

    public String getSigla() {
        return sigla;
    }

    public String getValor() {
        return valor;
    }

    public String getQtd() {
        return quantidade;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataOp(Integer data_operacao) {
        this.data_operacao = data_operacao;
    }

    public void setTipoOp(String tipo_operacao) {
        this.tipo_operacao = tipo_operacao;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setQtd(String quantidade) {
        this.quantidade = quantidade;
    }


}
