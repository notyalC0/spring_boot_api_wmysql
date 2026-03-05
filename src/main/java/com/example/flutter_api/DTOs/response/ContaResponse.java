package com.example.flutter_api.DTOs.response;

import com.example.flutter_api.models.Conta;

public record ContaResponse(Long id, double saldo) {
    public static ContaResponse from(Conta conta) {
        return new ContaResponse(conta.getId(), conta.getSaldo());
    }
}
