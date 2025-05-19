package br.com.easymoto.dto;

import jakarta.validation.constraints.*;

public record FuncionarioRequest(
        @NotBlank
        @Size(max = 100)
        String nomeFunc,

        @NotBlank
        @Size(min = 11, max = 11)
        String cpfFunc,

        @NotBlank
        @Size(max = 50)
        String cargo,

        @NotBlank
        @Size(max = 15)
        String telefoneFunc,

        @NotBlank
        @Email
        @Size(max = 100)
        String emailFunc,

        @NotNull
        Long filialId
) {}
