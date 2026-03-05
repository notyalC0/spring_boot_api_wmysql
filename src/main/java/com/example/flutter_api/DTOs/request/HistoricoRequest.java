package com.example.flutter_api.DTOs.request;

public record HistoricoRequest(
        Long dataOp,
        String tipoOp,
        String moeda,
        String sigla,
        String valor,
        String quantidade

) {
}
