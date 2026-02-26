package com.example.flutter_api.repositorys;


import com.example.flutter_api.models.Favoritas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritasRepository extends JpaRepository<Favoritas, String> {

}
