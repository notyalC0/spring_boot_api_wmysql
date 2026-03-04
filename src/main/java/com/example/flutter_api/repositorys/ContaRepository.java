package com.example.flutter_api.repositorys;

import com.example.flutter_api.models.Conta;
import com.example.flutter_api.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    List<Conta> findByUser(Users user);
    Optional<Conta> findByIdAndUser(Long id, Users user);
}
