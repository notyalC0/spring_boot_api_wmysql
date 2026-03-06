package com.example.flutter_api.DTOs.response;

import com.example.flutter_api.models.Carteira;

public record CarteiraResponse(
        Long id,
        String sigla,
        String moeda,
        double quantidade
        ) {

    public static CarteiraResponse from(Carteira carteira) {
        return new CarteiraResponse(carteira.getId(), carteira.getSigla(), carteira.getMoeda(), carteira.getQuantidade());
    }

}
