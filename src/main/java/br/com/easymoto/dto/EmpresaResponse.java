package br.com.easymoto.dto;

public record EmpresaResponse(
        Long id,
        String nomeEmpresa,
        String cnpj
) {}
