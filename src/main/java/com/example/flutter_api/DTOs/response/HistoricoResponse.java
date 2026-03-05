package com.example.flutter_api.DTOs.response;

import com.example.flutter_api.models.Historico;

public record HistoricoResponse(
        Long id,
        Long dataOp,
        String tipoOp,
        String moeda,
        String sigla,
        String valor,
        String quantidade
) {
    public static HistoricoResponse from(Historico historico) {
        return new HistoricoResponse(historico.getId(), historico.getDataOp(), historico.getTipoOp(), historico.getMoeda(), historico.getSigla(), historico.getValor(), historico.getQtd());
    }
}
