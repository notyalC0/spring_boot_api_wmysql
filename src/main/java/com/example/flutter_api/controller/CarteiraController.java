package com.example.flutter_api.controller;

import com.example.flutter_api.models.Carteira;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.services.CarteiraService;
import com.example.flutter_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carteira")
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;

    @Autowired
    private UserService userService;

    @GetMapping
    List<Carteira> getAllCarteira() {
        Users user = userService.getUsuarioLogado();
        return carteiraService.getAllByUsers(user);
    }

    @GetMapping("/{sigla}")
    public Carteira getCarteiraById(@PathVariable String sigla) {
        Users user = userService.getUsuarioLogado();
        return carteiraService.getAllByIdAndUser(sigla, user);
    }

    @PostMapping
    public Carteira adicionarCarteira(@RequestBody Carteira carteira) {
        Users user = userService.getUsuarioLogado();
        carteira.setUser(user);
        return carteiraService.adicionarCarteira(carteira);
    }

    @PutMapping("/{sigla}")
    public Carteira atualizarCarteira(@RequestBody Carteira carteira, @PathVariable String sigla) {
        Users user = userService.getUsuarioLogado();
        carteira.setSigla(sigla);
        carteira.setUser(user);
        return carteiraService.atualizarCarteira(carteira);
    }

    @DeleteMapping("/{sigla}")
    public void deletarCarteira(@PathVariable String sigla) {
        Users user = userService.getUsuarioLogado();
        carteiraService.deletarCarteiraBySigla(sigla, user);
    }

}
