package com.example.flutter_api.controller;


import com.example.flutter_api.DTOs.request.TransacaoRequest;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/comprar")
    public ResponseEntity<String> compra(
            @AuthenticationPrincipal Users user,
            @RequestBody TransacaoRequest request
    ) {
        transacaoService.realizarCompra(user, request.sigla(), request.quantidade());

        return ResponseEntity.ok("Compra de " + request.sigla() + " realizada com sucesso!");
    }

    @PostMapping("/vender")
    public ResponseEntity<String> venda(@AuthenticationPrincipal Users user,
                                        @RequestBody TransacaoRequest request
    ) {
        transacaoService.realizarVenda(user, request.sigla(), request.quantidade());

        return ResponseEntity.ok("Venda de " + request.sigla() + " realizada com sucesso!");

    }


    @PostMapping("/carrinho")
    public ResponseEntity<String> processarCarrinho(
            @AuthenticationPrincipal Users user,
            @RequestBody List<TransacaoRequest> itensRequest
    ) {
        transacaoService.processarCarrinho(user, itensRequest);

        return ResponseEntity.ok("Todos os itens do carrinho foram processados... Compra realizada com sucesso!");
    }


}
