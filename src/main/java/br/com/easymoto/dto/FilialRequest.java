package br.com.easymoto.dto;

import jakarta.validation.constraints.*;

public record FilialRequest(
        @NotBlank
        @Size(max = 50)
        String nomeFilial,

        @NotBlank
        @Size(max = 50)
        String cidade,

        @NotBlank
        @Size(min = 2, max = 2)
        String estado,

        @NotBlank
        @Size(max = 50)
        String pais,

        @NotBlank
        @Size(max = 100)
        String endereco,

        @NotNull
        Long empresaId
) {}
