package com.example.flutter_api.repositorys;

import com.example.flutter_api.models.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CarteiraRepository extends JpaRepository<Carteira, Integer> {

}
