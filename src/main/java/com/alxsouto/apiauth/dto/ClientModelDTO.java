package com.alxsouto.apiauth.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.intellij.lang.annotations.Pattern;

import java.time.LocalDate;

public record ClientModelDTO(
        Long id,

        //@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "O campo 'email' deve ser um endereço de e-mail válido")
        String email,
        String name,
        String phone,
        String cpf,
        LocalDate birthday

        ) {
}