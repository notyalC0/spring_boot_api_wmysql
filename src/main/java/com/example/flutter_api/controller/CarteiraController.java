package com.example.flutter_api.controller;

import com.example.flutter_api.DTOs.request.CarteiraRequest;
import com.example.flutter_api.DTOs.response.CarteiraResponse;
import com.example.flutter_api.models.Carteira;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.services.CarteiraService;
import com.example.flutter_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carteira")
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;


    @GetMapping
    List<CarteiraResponse> getAllCarteira(@AuthenticationPrincipal Users user) {

        return carteiraService.getAllByUsers(user)
                .stream()
                .map(CarteiraResponse::from)
                .toList();
    }

    /**
    @PostMapping
    public CarteiraResponse adicionarCarteira(@AuthenticationPrincipal Users user, @RequestBody CarteiraRequest dto) {
        Carteira carteira = new Carteira();
        carteira.setSigla(dto.sigla());
        carteira.setMoeda(dto.moeda());
        carteira.setQuantidade(dto.quantidade());
        carteira.setUser(user);

        return CarteiraResponse.from(carteiraService.adicionarCarteira(carteira));
    }

    @PutMapping("/{sigla}")
    public CarteiraResponse atualizarCarteira(@AuthenticationPrincipal Users user , @RequestBody CarteiraRequest dto, @PathVariable String sigla) {
        Carteira carteira = new Carteira();
        carteira.setSigla(sigla);
        carteira.setQuantidade(dto.quantidade());
        carteira.setUser(user);
        return CarteiraResponse.from(carteiraService.atualizarCarteira(carteira));
    }

    @DeleteMapping("/{sigla}")
    public void deletarCarteira( @AuthenticationPrincipal Users user,@PathVariable String sigla) {

        carteiraService.deletarCarteiraBySigla(sigla, user);
    } */

}
