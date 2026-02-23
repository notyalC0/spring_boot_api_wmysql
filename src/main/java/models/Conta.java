package models;

import jakarta.persistence.*;


@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue
    private int id;
    private double saldo;

    // getters


    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
