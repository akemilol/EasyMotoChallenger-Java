package br.com.easymoto.dto;

public record FuncionarioResponse(
        Long id,
        String nomeFunc,
        String cpfFunc,
        String cargo,
        String telefoneFunc,
        String emailFunc,
        Long filialId,
        String filialNome
) {}
