package com.example.flutter_api.controller;

import com.example.flutter_api.DTOs.request.FavoritasRequest;
import com.example.flutter_api.DTOs.response.FavoritasResponse;
import com.example.flutter_api.models.Favoritas;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.services.FavoritasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritas")
public class FavoritasController {

    @Autowired
    private FavoritasService favoritasService;

    @GetMapping
    public List<FavoritasResponse> getAllFavoritas(@AuthenticationPrincipal Users user) {


        return favoritasService.getAllByUsers(user)
                .stream()
                .map(FavoritasResponse::from)
                .toList();
    }

    @GetMapping("/{sigla}")
    public ResponseEntity<FavoritasResponse> getFavoritasById(@AuthenticationPrincipal Users user,  @PathVariable String sigla) {
        Favoritas favoritas = favoritasService.getByIdAndUsers(sigla, user);

        if (favoritas == null )  return ResponseEntity.notFound().build();

        return ResponseEntity.ok(FavoritasResponse.from(favoritas));
    }

    @PostMapping
    public FavoritasResponse setFavoritas(@AuthenticationPrincipal Users user, @RequestBody FavoritasRequest dto) {

        Favoritas existente = favoritasService.getByIdAndUsers(dto.sigla(), user);

        if (existente != null) {
            return FavoritasResponse.from(existente);
        }

        Favoritas favoritas = new Favoritas();
        favoritas.setSigla(dto.sigla());
        favoritas.setNome(dto.nome());
        favoritas.setIcone(dto.icone());
        favoritas.setValor(dto.valor());
        favoritas.setUser(user);
        return FavoritasResponse.from(favoritasService.setFavoritas(favoritas));
    }

    @PutMapping("/{sigla}")
    public FavoritasResponse updateFavoritas(@AuthenticationPrincipal Users user ,@RequestBody FavoritasRequest dto, @PathVariable String sigla) {

        Favoritas existente = favoritasService.getByIdAndUsers(sigla, user);
        if (existente == null ) return null;

        existente.setNome(dto.nome());
        existente.setIcone(dto.icone());
        existente.setValor(dto.valor());
        return FavoritasResponse.from(favoritasService.setFavoritas(existente));
    }

    @DeleteMapping("/{sigla}")
    public void deleteFavoritas( @AuthenticationPrincipal Users user, @PathVariable String sigla) {
        favoritasService.deleteFavoritas(sigla, user);
    }


}
