package br.com.easymoto.service;

import br.com.easymoto.dto.PatioRequest;
import br.com.easymoto.dto.PatioResponse;
import br.com.easymoto.model.Filial;
import br.com.easymoto.model.Patio;
import br.com.easymoto.repository.FilialRepository;
import br.com.easymoto.repository.PatioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatioService {

    private final PatioRepository patioRepository;
    private final FilialRepository filialRepository;

    @Cacheable("patios")
    public Page<PatioResponse> listar(String nome, Pageable pageable) {
        if (nome != null && !nome.isEmpty()) {
            return patioRepository.findByNomePatioContainingIgnoreCase(nome, pageable)
                    .map(this::toResponse);
        } else {
            return patioRepository.findAll(pageable)
                    .map(this::toResponse);
        }
    }

    public PatioResponse buscarPorId(Long id) {
        Patio patio = patioRepository.findById(id).orElseThrow();
        return toResponse(patio);
    }

    @CacheEvict(value = "patios", allEntries = true)
    public PatioResponse salvar(PatioRequest dto) {
        Filial filial = filialRepository.findById(dto.filialId()).orElseThrow();
        Patio patio = new Patio(
                null,
                dto.nomePatio(),
                dto.tamanhoPatio(),
                dto.andar(),
                filial
        );
        return toResponse(patioRepository.save(patio));
    }

    @CacheEvict(value = "patios", allEntries = true)
    public PatioResponse atualizar(Long id, PatioRequest dto) {
        Patio patio = patioRepository.findById(id).orElseThrow();
        Filial filial = filialRepository.findById(dto.filialId()).orElseThrow();
        patio.setNomePatio(dto.nomePatio());
        patio.setTamanhoPatio(dto.tamanhoPatio());
        patio.setAndar(dto.andar());
        patio.setFilial(filial);
        return toResponse(patioRepository.save(patio));
    }

    @CacheEvict(value = "patios", allEntries = true)
    public void deletar(Long id) {
        patioRepository.deleteById(id);
    }

    private PatioResponse toResponse(Patio patio) {
        return new PatioResponse(
                patio.getId(),
                patio.getNomePatio(),
                patio.getTamanhoPatio(),
                patio.getAndar(),
                patio.getFilial().getId(),
                patio.getFilial().getNomeFilial()
        );
    }
}
