package com.example.flutter_api.repositorys;

import com.example.flutter_api.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByEmail(String email);
    // optional sinaliza que a funcao pode nao retornar usuarios
}
