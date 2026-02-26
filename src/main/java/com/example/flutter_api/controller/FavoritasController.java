package com.example.flutter_api.controller;

import com.example.flutter_api.models.Favoritas;
import com.example.flutter_api.services.FavoritasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritas")
public class FavoritasController {

    @Autowired
    FavoritasService favoritasService;

    @GetMapping
    public List<Favoritas> getAllFavoritas() {
        return favoritasService.getAllFavoritas();
    }

    @GetMapping("/{sigla}")
    public Favoritas getFavoritasById(@PathVariable String sigla) {
        return favoritasService.getFavoritasById(sigla);
    }

    @PostMapping
    public Favoritas setFavoritas(@RequestBody Favoritas favoritas) {
        return favoritasService.setFavoritas(favoritas);
    }

    @PutMapping("/{sigla}")
    public Favoritas updateFavoritas(@RequestBody Favoritas favoritas, @PathVariable String sigla) {
        favoritas.setSigla(sigla);
        return favoritasService.updateFavoritas(favoritas);
    }

    @DeleteMapping("/{sigla}")
    public void deleteFavoritas(@PathVariable String sigla) {
        favoritasService.deleteFavoritas(sigla);
    }


}
