package com.example.flutter_api.services;

import com.example.flutter_api.models.Carteira;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.repositorys.CarteiraRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteiraService {

    private CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    public List<Carteira> getAllByUsers(Users user) {
        return carteiraRepository.findByUser(user);
    }

    public Carteira getAllByIdAndUser(String sigla, Users user) {
        return carteiraRepository.findBySiglaAndUser(sigla, user).orElse(null);
    }

    public Carteira adicionarCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }

    public Carteira atualizarCarteira(Carteira carteira) {
        var existente = carteiraRepository.findBySiglaAndUser(carteira.getSigla(), carteira.getUser())
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada"));
        existente.setQuantidade(carteira.getQuantidade());

        return carteiraRepository.save(existente);
    }
    @Transactional
    public void deletarCarteiraBySigla(String sigla, Users user) {

        carteiraRepository.deleteBySiglaAndUser(sigla, user);
    }

}
