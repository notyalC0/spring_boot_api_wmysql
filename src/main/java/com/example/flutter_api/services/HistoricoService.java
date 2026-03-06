package com.example.flutter_api.services;

import com.example.flutter_api.models.Historico;
import com.example.flutter_api.models.Users;
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

    public List<Historico> getAllByUsers(Users user) {
        return historicoRepository.findByUser(user);

    }

}
