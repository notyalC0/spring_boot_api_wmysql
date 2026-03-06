package com.example.flutter_api.services;


import com.example.flutter_api.DTOs.request.TransacaoRequest;
import com.example.flutter_api.models.*;
import com.example.flutter_api.repositorys.CarteiraRepository;
import com.example.flutter_api.repositorys.ContaRepository;
import com.example.flutter_api.repositorys.HistoricoRepository;
import com.example.flutter_api.repositorys.MoedaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    CarteiraRepository carteiraRepository;
    @Autowired
    HistoricoRepository historicoRepository;
    @Autowired
    MoedaRepository moedaRepository;


    @Transactional
    public void realizarCompra(Users user, String sigla, double quantidade) {
        Conta conta = contaRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada!"));

        Moeda moeda = moedaRepository.findById(sigla)
                .orElseThrow(() -> new RuntimeException("Moeda não encontrada!"));

        double valorDaTransacao = moeda.getValor() * quantidade;

        if (conta.getSaldo() < valorDaTransacao) {
            throw new RuntimeException("Saldo insuficiente!");
        }

        conta.setSaldo(conta.getSaldo() - valorDaTransacao);
        contaRepository.save(conta);

        Optional<Carteira> carteira = carteiraRepository.findBySiglaAndUser(sigla, user);
        if (carteira.isPresent()) {
            Carteira carteiraAtt = carteira.get();
            carteiraAtt.setQuantidade(carteiraAtt.getQuantidade() + quantidade);
            carteiraRepository.save(carteiraAtt);
        } else {
            Carteira novaCarteira = new Carteira();
            novaCarteira.setUser(user);
            novaCarteira.setSigla(sigla);
            novaCarteira.setQuantidade(quantidade);
            novaCarteira.setMoeda(moeda.getNome());
            carteiraRepository.save(novaCarteira);
        }

        Historico historico = new Historico();
        historico.setDataOp(System.currentTimeMillis());
        historico.setTipoOp("compra");
        historico.setSigla(sigla);
        historico.setMoeda(moeda.getNome());
        historico.setQtd(String.valueOf(quantidade));
        historico.setValor(String.valueOf(moeda.getValor()));
        historico.setUser(user);
        historicoRepository.save(historico);
    }

    @Transactional
    public void processarCarrinho(Users user, List<TransacaoRequest> itens) {
        for (TransacaoRequest item: itens) {
            realizarCompra(user, item.sigla(), item.quantidade());
        }

    }

    @Transactional
    public void realizarVenda(Users user, String sigla, double quantidade) {
        Conta conta = contaRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada!"));

        Moeda moeda = moedaRepository.findById(sigla)
                .orElseThrow(() -> new RuntimeException("Moeda não encontrada!"));

        double valorDaTransacao = moeda.getValor() * quantidade;

        Carteira carteira = carteiraRepository.findBySiglaAndUser(sigla, user)
                .orElseThrow(() -> new RuntimeException("Você não possui essa moeda!"));

        if (carteira.getQuantidade() < quantidade) {
            throw new RuntimeException("Quantidade insuficiente!");
        }

        carteira.setQuantidade(carteira.getQuantidade() - quantidade);

        if (carteira.getQuantidade() <= 0) {
            carteiraRepository.delete(carteira);
        } else {
            carteiraRepository.save(carteira);
        }

        conta.setSaldo(conta.getSaldo() + valorDaTransacao);
        contaRepository.save(conta);

        Historico historico = new Historico();
        historico.setDataOp(System.currentTimeMillis());
        historico.setTipoOp("venda");
        historico.setSigla(sigla);
        historico.setMoeda(moeda.getNome());
        historico.setQtd(String.valueOf(quantidade));
        historico.setValor(String.valueOf(moeda.getValor()));
        historico.setUser(user);
        historicoRepository.save(historico);
    }
}
