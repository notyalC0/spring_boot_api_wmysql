package com.example.flutter_api.DTOs.request;

public record FavoritasRequest(
        String sigla,
        String nome,
        String icone,
        String valor
        ) {
}
