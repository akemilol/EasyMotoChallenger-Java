package br.com.easymoto.dto;

public record ClienteResponse(
        Long id,
        String nomeCliente,
        String cpfCliente,
        String telefoneCliente,
        String emailCliente
) {}
