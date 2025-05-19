package br.com.easymoto.dto;

import java.time.LocalDateTime;

public record LocalizacaoResponse(
        Long id,
        String statusLoc,
        LocalDateTime dataHora,
        String zonaVirtual,
        Double latitude,
        Double longitude
) {}
