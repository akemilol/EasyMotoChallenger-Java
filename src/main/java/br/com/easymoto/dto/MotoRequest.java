package br.com.easymoto.dto;

import jakarta.validation.constraints.*;

public record MotoRequest(
        @NotBlank
        @Size(max = 10)
        String placa,

        @NotBlank
        @Size(max = 50)
        String modelo,

        @NotNull
        Integer anoFabricacao,

        @NotBlank
        @Size(max = 20)
        String statusMoto,

        @NotNull
        Long locacaoId,

        @NotNull
        Long localizacaoId
) {}
