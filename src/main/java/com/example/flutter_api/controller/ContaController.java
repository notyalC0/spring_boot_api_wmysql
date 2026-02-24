package com.example.flutter_api.controller;

import com.example.flutter_api.models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.flutter_api.services.ContaService;

import java.util.List;


@RestController
@RequestMapping("/api/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;


    @PostMapping
    Conta salvarConta(@RequestBody Conta conta) {
        return contaService.salvarConta(conta);
    }

    @GetMapping
    public List<Conta> getAllContas() {
        return contaService.getAllContas();
    }

    @GetMapping("/{id}")
    public Conta getAllContasById(@PathVariable Long id) {
        return contaService.getAllContasById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarConta(@PathVariable Long id) {
        contaService.delete(id);
    }

    @PutMapping("/{id}")
    public Conta editarContar(@PathVariable Long id, @RequestBody Conta conta) {
        conta.setId(id);
        return contaService.update(conta);
    }

}
