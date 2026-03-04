package com.example.flutter_api.controller;


import com.example.flutter_api.models.Historico;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.services.HistoricoService;
import com.example.flutter_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Historico> getAllHistorico() {
        Users user = userService.getUsuarioLogado();

        return historicoService.getAllByUsers(user);
    }

    @GetMapping("/{id}")
    public Historico getHistoricoById(@PathVariable Long id) {
        Users user = userService.getUsuarioLogado();
        return historicoService.getHistoricoById(id,user);
    }

    @PostMapping
    public Historico adicionarHistorico(@RequestBody Historico historico) {
        Users user = userService.getUsuarioLogado();
        historico.setUser(user);
        return historicoService.adicionarHistorico(historico);
    }

    @PutMapping("/{id}")
    public Historico editarHistorico(@RequestBody Historico historico, @PathVariable Long id) {
        Users user = userService.getUsuarioLogado();
        historico.setId(id);
        historico.setUser(user);
        return historicoService.editarHistorico(historico);
    }

    @DeleteMapping("/{id}")
    public void deletarHistorico(@PathVariable Long id) {
        historicoService.deletarHistorico(id);
    }

}
