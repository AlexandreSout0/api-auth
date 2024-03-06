package com.alxsouto.apiauth.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public record AddressModelDTO(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id_address,
        String address_line1,
        String address_line2,
        String cep,
        int number,
        String city,
        String country,
        String state

) {
}