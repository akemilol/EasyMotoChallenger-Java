package br.com.easymoto.dto;

import jakarta.validation.constraints.*;

public record VagaRequest(
        @NotBlank
        @Size(max = 20)
        String statusVaga,

        @NotNull
        Long patioId,

        @NotNull
        Long motoId,

        @NotBlank
        @Size(max = 1)
        String fileira,

        @NotBlank
        @Size(max = 1)
        String coluna
) {}
