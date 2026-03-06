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



}
