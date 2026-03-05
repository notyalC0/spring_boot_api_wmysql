package com.example.flutter_api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "favoritas")
public class Favoritas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icone;
    private String nome;
    private String sigla;
    private String valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false )
    private Users user;


    public Favoritas() {
    }

    public Favoritas(Long id, String icone, String nome, String sigla, String valor, Users user) {
        this.id = id;
        this.icone = icone;
        this.nome = nome;
        this.sigla = sigla;
        this.valor = valor;
        this.user = user;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
