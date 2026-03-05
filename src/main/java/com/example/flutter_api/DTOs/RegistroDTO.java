package com.example.flutter_api.DTOs;

import com.example.flutter_api.models.UserRole;

public record RegistroDTO(String email, String senha, UserRole role) {
}
