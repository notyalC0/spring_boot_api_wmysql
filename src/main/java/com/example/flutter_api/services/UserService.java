package com.example.flutter_api.services;

import com.example.flutter_api.infra.security.SecurityFilter;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.repositorys.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public Users getUsuarioLogado() {

        var email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return usersRepository.findByEmail(email);
    }
}
