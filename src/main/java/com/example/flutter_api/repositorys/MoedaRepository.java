package com.example.flutter_api.repositorys;

import com.example.flutter_api.models.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoedaRepository extends JpaRepository <Moeda, String> { }
