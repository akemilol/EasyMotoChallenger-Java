package br.com.easymoto.dto;

import java.time.LocalDate;

public record ClienteLocacaoResponse(
        Long id,
        LocalDate dataInicio,
        LocalDate dataFim,
        String statusLocacao,
        Long clienteId,
        String clienteNome
) {}
