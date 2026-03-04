package com.example.flutter_api.repositorys;

import com.example.flutter_api.models.Historico;
import com.example.flutter_api.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    List<Historico> findByUser(Users user);


    Optional<Historico> findByIdAndUser(Long id, Users user);
}
