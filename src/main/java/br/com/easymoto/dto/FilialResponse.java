package br.com.easymoto.dto;

public record FilialResponse(
        Long id,
        String nomeFilial,
        String cidade,
        String estado,
        String pais,
        String endereco,
        Long empresaId,
        String empresaNome
) {}
