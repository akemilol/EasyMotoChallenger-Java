package br.com.easymoto.dto;

public record OperadorResponse(
        Long id,
        String nomeOpr,
        String cpfOpr,
        String telefoneOpr,
        String emailOpr,
        Long filialId,
        String filialNome
) {}
