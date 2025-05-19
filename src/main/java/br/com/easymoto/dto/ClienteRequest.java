package br.com.easymoto.dto;

import jakarta.validation.constraints.*;

public record ClienteRequest(
        @NotBlank
        @Size(max = 100)
        String nomeCliente,

        @NotBlank
        @Size(min = 11, max = 11)
        String cpfCliente,

        @NotBlank
        @Size(max = 15)
        String telefoneCliente,

        @NotBlank
        @Email
        @Size(max = 100)
        String emailCliente
) {}
