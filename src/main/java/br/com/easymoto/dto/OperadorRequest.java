package br.com.easymoto.dto;

import jakarta.validation.constraints.*;

public record OperadorRequest(
        @NotBlank
        @Size(max = 100)
        String nomeOpr,

        @NotBlank
        @Size(min = 11, max = 11)
        String cpfOpr,

        @NotBlank
        @Size(max = 14)
        String telefoneOpr,

        @NotBlank
        @Email
        @Size(max = 100)
        String emailOpr,

        @NotNull
        Long filialId
) {}
