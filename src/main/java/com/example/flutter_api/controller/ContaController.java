package com.example.flutter_api.controller;

import com.example.flutter_api.DTOs.request.ContaRequest;
import com.example.flutter_api.DTOs.response.ContaResponse;
import com.example.flutter_api.models.Conta;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.example.flutter_api.services.ContaService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private UserService userService;


    @GetMapping
    public List<ContaResponse> getAllContas(@AuthenticationPrincipal Users user) {



        return contaService.getAllByUsers(user)
                .stream()
                .map(ContaResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public ContaResponse getAllContasById( @AuthenticationPrincipal Users user,@PathVariable Long id) {
        Conta conta = contaService.getContasByIdAndUsers(id, user);
        if (conta == null) return null;


        return ContaResponse.from(conta);
    }

    @PostMapping
    public ContaResponse salvarConta(@AuthenticationPrincipal Users user, @RequestBody ContaRequest dto) {
        Conta conta = new Conta();
        conta.setSaldo(dto.saldo());
        return ContaResponse.from(contaService.salvarConta(conta));
    }

    @PutMapping("/{id}")
    public Conta editarContar(@PathVariable Long id, @RequestBody Conta conta) {
        Users user = userService.getUsuarioLogado();
        conta.setId(id);
        conta.setUser(user);
        return contaService.update(conta);
    }

    @PatchMapping("/depositar")
    public ResponseEntity<ContaResponse> depositar(
            @AuthenticationPrincipal Users user,
            @RequestBody Map<String, Double> body
    ) {
        Double valor = body.get("valor");
        if (valor == null || valor <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Conta conta = contaService.depositar(user, valor);
        return ResponseEntity.ok(ContaResponse.from(conta));
    }


    @DeleteMapping("/{id}")
    public void deletarConta( @PathVariable Long id) {

        contaService.delete(id);
    }

}
