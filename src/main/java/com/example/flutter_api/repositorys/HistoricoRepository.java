package com.example.flutter_api.repositorys;

import com.example.flutter_api.models.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface HistoricoRepository extends JpaRepository<Historico, Integer> {
}
