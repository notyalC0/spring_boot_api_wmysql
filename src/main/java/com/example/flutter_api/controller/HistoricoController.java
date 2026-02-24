package com.example.flutter_api.controller;


import com.example.flutter_api.models.Historico;
import com.example.flutter_api.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public List<Historico> getAllHistorico() {
        return historicoService.getAllHistorico();
    }

    @GetMapping("/{id}")
    public Historico getHistoricoById(@PathVariable Long id) {
        return historicoService.getHistoricoById(id);
    }

    @PostMapping
    public Historico adicionarHistorico(@RequestBody Historico historico) {
        return historicoService.adicionarHistorico(historico);
    }

    @PutMapping("/{id}")
    public Historico editarHistorico(@RequestBody Historico historico, @PathVariable Long id) {
        return historicoService.editarHistorico(historico, id);
    }

    @DeleteMapping("/{id}")
    public void deletarHistorico(@PathVariable Long id) {
        historicoService.deletarHistorico(id);
    }

}
