package com.example.flutter_api.models;

import jakarta.persistence.*;


@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "saldo")
    private double saldo;

    Conta() {
    }

    Conta(Long id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    // getters


    public Long getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
