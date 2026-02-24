package com.example.flutter_api.services;

import com.example.flutter_api.models.Conta;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.flutter_api.repositorys.ContaRepository;

@Service
public class ContaService {

    private ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    public Conta getAllContasById(Long id) {
        return contaRepository.findById(id).orElse(null);
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
