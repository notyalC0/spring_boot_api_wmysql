package com.example.flutter_api.repositorys;

import com.example.flutter_api.models.Carteira;
import com.example.flutter_api.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, String> {

    List<Carteira> findByUser(Users user);
    Optional<Carteira> findBySiglaAndUser(String sigla, Users user);
    void deleteBySiglaAndUser(String sigla, Users user);
}
