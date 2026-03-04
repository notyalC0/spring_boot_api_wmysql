package com.example.flutter_api.controller;

import com.example.flutter_api.models.Moeda;
import com.example.flutter_api.repositorys.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/moeda")
public class MoedaController {

    @Autowired
   private MoedaRepository moedaRepository;

    @GetMapping
    public List<Moeda> getAllMoedas() {
        return moedaRepository.findAll();
    }
}
