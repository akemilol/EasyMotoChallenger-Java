package br.com.easymoto.service;

import br.com.easymoto.dto.LocalizacaoRequest;
import br.com.easymoto.dto.LocalizacaoResponse;
import br.com.easymoto.model.Localizacao;
import br.com.easymoto.repository.LocalizacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocalizacaoService {

    private final LocalizacaoRepository repository;

    @Cacheable("localizacoes")
    public Page<LocalizacaoResponse> listar(String status, Pageable pageable) {
        if (status != null && !status.isEmpty()) {
            return repository.findByStatusLocContainingIgnoreCase(status, pageable)
                    .map(this::toResponse);
        } else {
            return repository.findAll(pageable)
                    .map(this::toResponse);
        }
    }

    public LocalizacaoResponse buscarPorId(Long id) {
        Localizacao localizacao = repository.findById(id).orElseThrow();
        return toResponse(localizacao);
    }

    @CacheEvict(value = "localizacoes", allEntries = true)
    public LocalizacaoResponse salvar(LocalizacaoRequest dto) {
        Localizacao localizacao = new Localizacao(
                null,
                dto.statusLoc(),
                dto.dataHora(),
                dto.zonaVirtual(),
                dto.latitude(),
                dto.longitude()
        );
        return toResponse(repository.save(localizacao));
    }

    @CacheEvict(value = "localizacoes", allEntries = true)
    public LocalizacaoResponse atualizar(Long id, LocalizacaoRequest dto) {
        Localizacao localizacao = repository.findById(id).orElseThrow();
        localizacao.setStatusLoc(dto.statusLoc());
        localizacao.setDataHora(dto.dataHora());
        localizacao.setZonaVirtual(dto.zonaVirtual());
        localizacao.setLatitude(dto.latitude());
        localizacao.setLongitude(dto.longitude());
        return toResponse(repository.save(localizacao));
    }

    @CacheEvict(value = "localizacoes", allEntries = true)
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private LocalizacaoResponse toResponse(Localizacao localizacao) {
        return new LocalizacaoResponse(
                localizacao.getId(),
                localizacao.getStatusLoc(),
                localizacao.getDataHora(),
                localizacao.getZonaVirtual(),
                localizacao.getLatitude(),
                localizacao.getLongitude()
        );
    }
}
