package com.example.flutter_api.controller;

import com.example.flutter_api.infra.security.TokenService;
import com.example.flutter_api.models.AuthenticationDTO;
import com.example.flutter_api.models.LoginResponseDTO;
import com.example.flutter_api.models.RegistroDTO;
import com.example.flutter_api.models.Users;
import com.example.flutter_api.repositorys.UsersRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) { // recebe os dados
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha()); // tranforma em token
        var auth = this.authenticationManager.authenticate(userNamePassword); // verifica no banco atraves da userdetail

        var token = tokenService.gerarToken((Users) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody RegistroDTO data) {
        if (this.usersRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Users newUser = new Users(data.email(), encryptedPassword, data.role());

        this.usersRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
