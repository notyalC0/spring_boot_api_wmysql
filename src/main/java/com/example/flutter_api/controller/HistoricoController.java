package com.example.flutter_api.controller;


import com.example.flutter_api.DTOs.request.HistoricoRequest;
import com.example.flutter_api.DTOs.response.HistoricoResponse;
import com.example.flutter_api.models.Favoritas;
import com.example.flutter_api.models.Historico;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.services.HistoricoService;
import com.example.flutter_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public List<HistoricoResponse> getAllHistorico(@AuthenticationPrincipal Users user) {

        return historicoService.getAllByUsers(user)
                .stream()
                .map(HistoricoResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public HistoricoResponse getHistoricoById(@AuthenticationPrincipal Users user ,@PathVariable Long id) {
        Historico historico = historicoService.getHistoricoById(id,user);
        return HistoricoResponse.from(historico);
    }

    @PostMapping
    public HistoricoResponse adicionarHistorico(@AuthenticationPrincipal Users user,@RequestBody HistoricoRequest dto) {
        if (dto.dataOp() == null || dto.tipoOp() == null) {
            throw new RuntimeException("dataOp e tipoOp são obrigatórios");
        }

        Historico historico = new Historico();
        historico.setDataOp(dto.dataOp());
        historico.setTipoOp(dto.tipoOp());
        historico.setMoeda(dto.moeda());
        historico.setSigla(dto.sigla());
        historico.setValor(dto.valor());
        historico.setQtd(dto.quantidade());
        historico.setUser(user);

        return HistoricoResponse.from(historicoService.adicionarHistorico(historico));
    }





}
