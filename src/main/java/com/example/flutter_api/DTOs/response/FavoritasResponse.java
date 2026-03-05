package com.example.flutter_api.DTOs.response;

import com.example.flutter_api.models.Favoritas;

public record FavoritasResponse(
        String sigla,
        String nome,
        String icone,
        String valor
) {
    public static FavoritasResponse from(Favoritas favoritas) {
        return new FavoritasResponse(favoritas.getSigla(), favoritas.getNome(), favoritas.getIcone(), favoritas.getValor());
    }
}
