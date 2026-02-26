package com.example.flutter_api.services;

import com.example.flutter_api.models.Favoritas;
import com.example.flutter_api.repositorys.FavoritasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritasService {

    private FavoritasRepository favoritasRepository;

    public FavoritasService(FavoritasRepository favoritasRepository) {
        this.favoritasRepository = favoritasRepository;
    }

    public List<Favoritas> getAllFavoritas() {
        return favoritasRepository.findAll();
    }

    public Favoritas getFavoritasById(String sigla) {
        return favoritasRepository.findById(sigla).orElse(null);
    }

    public Favoritas setFavoritas(Favoritas favoritas) {
        return favoritasRepository.save(favoritas);
    }

    public Favoritas updateFavoritas(Favoritas favoritas) {
        return favoritasRepository.save(favoritas);
    }

    public void deleteFavoritas(String sigla) {
        favoritasRepository.deleteById(sigla);
    }

}
