package br.com.easymoto.dto;

import jakarta.validation.constraints.*;

public record EmpresaRequest(
        @NotBlank
        @Size(max = 50)
        String nomeEmpresa,

        @NotBlank
        @Size(min = 14, max = 14)
        String cnpj
) {}
