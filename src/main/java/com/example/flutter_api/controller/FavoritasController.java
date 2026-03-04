package com.example.flutter_api.controller;

import com.example.flutter_api.models.Favoritas;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.services.FavoritasService;
import com.example.flutter_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritas")
public class FavoritasController {

    @Autowired
    private FavoritasService favoritasService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Favoritas> getAllFavoritas() {

        Users user = userService.getUsuarioLogado();
        return favoritasService.getAllByUsers(user);
    }

    @GetMapping("/{sigla}")
    public Favoritas getFavoritasById(@PathVariable String sigla) {
        Users user = userService.getUsuarioLogado();

        return favoritasService.getByIdAndUsers(sigla, user);
    }

    @PostMapping
    public Favoritas setFavoritas(@RequestBody Favoritas favoritas) {
        Users user = userService.getUsuarioLogado();
        favoritas.setUser(user);
        return favoritasService.setFavoritas(favoritas);
    }

    @PutMapping("/{sigla}")
    public Favoritas updateFavoritas(@RequestBody Favoritas favoritas, @PathVariable String sigla) {

        Users user = userService.getUsuarioLogado();
        favoritas.setSigla(sigla);
        favoritas.setUser(user);
        return favoritasService.updateFavoritas(favoritas);
    }

    @DeleteMapping("/{sigla}")
    public void deleteFavoritas(@PathVariable String sigla) {
        favoritasService.deleteFavoritas(sigla);
    }


}
