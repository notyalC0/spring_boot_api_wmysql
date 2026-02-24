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

    @GetMapping("/{id}")
    public Carteira getCarteiraById(@PathVariable String id) {
        return carteiraService.getAllCarteiraById(id);
    }

    @PostMapping
    public Carteira adicionarCarteira(@RequestBody Carteira carteira) {
        return carteiraService.adicionarCarteira(carteira);
    }

    @PutMapping("/{id}")
    public Carteira atualizarCarteira(@RequestBody Carteira carteira, String id) {
        return carteiraService.atualizarCarteira(carteira, id);
    }

    @DeleteMapping("/{id}")
    public void deletarCarteira(String id) {
        carteiraService.deletarCarteira(id);
    }

}
