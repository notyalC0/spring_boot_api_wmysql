package services;

import models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import repositorys.ContaRepository;

@Service public class ContaService {
    @Autowired private ContaRepository contaRepository;
}
