package br.com.easymoto.dto;

import jakarta.validation.constraints.*;

public record PatioRequest(
        @NotBlank
        @Size(max = 50)
        String nomePatio,

        @NotBlank
        @Size(max = 50)
        String tamanhoPatio,

        @NotBlank
        @Size(max = 1)
        String andar,

        @NotNull
        Long filialId
) {}
