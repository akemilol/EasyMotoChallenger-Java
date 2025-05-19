package br.com.easymoto.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public record LocalizacaoRequest(
        @NotBlank
        @Size(max = 20)
        String statusLoc,

        @NotNull
        LocalDateTime dataHora,

        @NotBlank
        @Size(max = 50)
        String zonaVirtual,

        @NotNull
        Double latitude,

        @NotNull
        Double longitude
) {}
