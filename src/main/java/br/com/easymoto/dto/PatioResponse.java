package br.com.easymoto.dto;

public record PatioResponse(
        Long id,
        String nomePatio,
        String tamanhoPatio,
        String andar,
        Long filialId,
        String filialNome
) {}
