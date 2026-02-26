package com.example.flutter_api.controller;

import com.example.flutter_api.models.Carteira;
import com.example.flutter_api.services.CarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carteira")
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;

    @GetMapping
    List<Carteira> getAllCarteira() {
        return carteiraService.getAllCarteira();
    }

    @GetMapping("/{sigla}")
    public Carteira getCarteiraById(@PathVariable String sigla) {
        return carteiraService.getAllCarteiraById(sigla);
    }

    @PostMapping
    public Carteira adicionarCarteira(@RequestBody Carteira carteira) {
        return carteiraService.adicionarCarteira(carteira);
    }

    @PutMapping("/{sigla}")
    public Carteira atualizarCarteira(@RequestBody Carteira carteira, @PathVariable String sigla) {
        carteira.setSigla(sigla);
        return carteiraService.atualizarCarteira(carteira);
    }

    @DeleteMapping("/{sigla}")
    public void deletarCarteira(@PathVariable String sigla) {
        carteiraService.deletarCarteira(sigla);
    }

}
