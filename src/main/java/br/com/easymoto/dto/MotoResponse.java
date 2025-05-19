package br.com.easymoto.dto;

public record MotoResponse(
        Long id,
        String placa,
        String modelo,
        Integer anoFabricacao,
        String statusMoto,
        Long locacaoId,
        Long localizacaoId
) {}
