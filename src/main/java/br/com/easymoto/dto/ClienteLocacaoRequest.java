package br.com.easymoto.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record ClienteLocacaoRequest(
        @NotNull
        LocalDate dataInicio,

        @NotNull
        LocalDate dataFim,

        @NotBlank
        @Size(max = 20)
        String statusLocacao,

        @NotNull
        Long clienteId
) {}
