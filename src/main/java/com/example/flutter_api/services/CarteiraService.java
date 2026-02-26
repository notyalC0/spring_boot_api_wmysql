package com.example.flutter_api.services;

import com.example.flutter_api.models.Carteira;
import com.example.flutter_api.repositorys.CarteiraRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarteiraService {

    private CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    public List<Carteira> getAllCarteira() {
        return carteiraRepository.findAll();
    }

    public Carteira getAllCarteiraById(String sigla) {
        return carteiraRepository.findById(sigla).orElse(null);
    }

    public Carteira adicionarCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }

    public Carteira atualizarCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }

    public void deletarCarteira(String sigla) {
        carteiraRepository.deleteById(sigla);
    }

}
