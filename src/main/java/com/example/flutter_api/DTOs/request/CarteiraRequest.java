package com.example.flutter_api.DTOs.request;

public record CarteiraRequest(
        String sigla,
        String moeda,
        String quantidade
) {}
