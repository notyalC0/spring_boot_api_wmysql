package com.example.flutter_api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "historico")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long data_operacao;

    private String tipo_operacao;

    private String moeda;

    private String sigla;

    private String valor;

    private String quantidade;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false )
    private Users user;

    // getters

    public Historico() {
    }

    public Historico(Long id, Long data_operacao, String tipo_operacao, String moeda, String sigla, String valor, String quantidade, Users user) {
        this.id = id;
        this.data_operacao = data_operacao;
        this.tipo_operacao = tipo_operacao;
        this.moeda = moeda;
        this.sigla = sigla;
        this.valor = valor;
        this.quantidade = quantidade;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Long getDataOp() {
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

    public Users getUser() {
        return user;
    }

    // Setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setDataOp(Long data_operacao) {
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

    public void setUser(Users user) {
        this.user = user;
    }
}
