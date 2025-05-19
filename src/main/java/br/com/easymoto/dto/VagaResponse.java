package br.com.easymoto.dto;

public record VagaResponse(
        Long id,
        String statusVaga,
        Long patioId,
        String patioNome,
        Long motoId,
        String motoPlaca,
        String fileira,
        String coluna
) {}
