package com.example.flutter_api.models;

import jakarta.persistence.*;


@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saldo")
    private double saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false )
            private Users user;

    public Conta() {
    }

    public Conta(Long id, double saldo, Users user) {
        this.id = id;
        this.saldo = saldo;
        this.user = user;
    }

    // getters


    public Long getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public Users getUser() {
        return user;
    }

    // setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
