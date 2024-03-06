package com.alxsouto.apiauth.dto;

import java.time.LocalDate;

public record RegisterDTO(
        //@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "O campo 'email' deve ser um endereço de e-mail válido")
        String email,
        String password,
        String name,
        String phone,
        String cpf,
        LocalDate birthday,
         String cep,
         String address_line1,
         String address_line2,
         int number,
         String city,
         String country,
         String state

) {
}
