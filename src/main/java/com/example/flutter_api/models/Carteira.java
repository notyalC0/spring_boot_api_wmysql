package com.example.flutter_api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "carteira")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sigla;

    private String moeda;

    private String quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false )
    private Users user;

    public Carteira() {
    }

    public Carteira(Long id, String sigla, String moeda, String quantidade, Users user) {
        this.id = id;
        this.sigla = sigla;
        this.moeda = moeda;
        this.quantidade = quantidade;
        this.user = user;
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

    public Long getId() {
        return id;
    }

    public Users getUser() {
        return user;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
