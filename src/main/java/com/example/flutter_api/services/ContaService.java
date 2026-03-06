package com.example.flutter_api.services;

import com.example.flutter_api.models.Conta;
import com.example.flutter_api.models.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.flutter_api.repositorys.ContaRepository;

@Service
public class ContaService {

    private ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Optional<Conta> getAllByUsers(Users user) {

        return contaRepository.findByUser(user);
    }

    public Conta getContasByIdAndUsers(Long id, Users user) {

        return contaRepository.findByIdAndUser(id, user).orElse(null);
    }

    public Conta salvarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta update(Conta conta) {
        return contaRepository.save(conta);
    }

    public void delete(Long id) {
        contaRepository.deleteById(id);
    }

}
