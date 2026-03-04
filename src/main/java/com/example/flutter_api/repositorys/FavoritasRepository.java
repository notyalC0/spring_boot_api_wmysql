package com.example.flutter_api.repositorys;


import com.example.flutter_api.models.Favoritas;
import com.example.flutter_api.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritasRepository extends JpaRepository<Favoritas, String> {

    List<Favoritas> findByUser(Users user);


    Optional<Favoritas> findBySiglaAndUser(String sigla, Users user);
}
