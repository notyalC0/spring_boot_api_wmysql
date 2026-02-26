package com.example.flutter_api.services;

import com.example.flutter_api.models.Historico;
import com.example.flutter_api.repositorys.HistoricoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService {

    private HistoricoRepository historicoRepository;

    public HistoricoService(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public List<Historico> getAllHistorico() {
        return historicoRepository.findAll();

    }

    public Historico getHistoricoById(Long id) {
        return historicoRepository.findById(id).orElse(null);
    }

    public Historico adicionarHistorico(Historico historico) {
        return historicoRepository.save(historico);
    }

    public Historico editarHistorico(Historico historico) {
        return historicoRepository.save(historico);
    }

    public void deletarHistorico(Long id) {

        historicoRepository.deleteById(id);
    }
}
