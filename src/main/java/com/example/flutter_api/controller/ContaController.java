package com.example.flutter_api.controller;

import com.example.flutter_api.models.Conta;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.flutter_api.services.ContaService;

import java.util.List;


@RestController
@RequestMapping("/api/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private UserService userService;


    @PostMapping
    public Conta salvarConta(@RequestBody Conta conta) {

        Users user = userService.getUsuarioLogado();
        conta.setUser(user);
        return contaService.salvarConta(conta);
    }

    @GetMapping
    public List<Conta> getAllContas() {

    Users user = userService.getUsuarioLogado();

        return contaService.getAllByUsers(user);
    }

    @GetMapping("/{id}")
    public Conta getAllContasById(@PathVariable Long id) {

        Users user = userService.getUsuarioLogado();
        return contaService.getContasByIdAndUsers(id, user);
    }

    @DeleteMapping("/{id}")
    public void deletarConta(@PathVariable Long id) {
        contaService.delete(id);
    }

    @PutMapping("/{id}")
    public Conta editarContar(@PathVariable Long id, @RequestBody Conta conta) {
        Users user = userService.getUsuarioLogado();
        conta.setId(id);
        conta.setUser(user);
        return contaService.update(conta);
    }

}
