package com.example.flutter_api.repositorys;

import com.example.flutter_api.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    UserDetails findByEmail(String email);
    // optional sinaliza que a funcao pode nao retornar usuarios
}
