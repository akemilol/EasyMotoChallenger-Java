package br.com.easymoto.service;

import br.com.easymoto.dto.FilialRequest;
import br.com.easymoto.dto.FilialResponse;
import br.com.easymoto.model.Empresa;
import br.com.easymoto.model.Filial;
import br.com.easymoto.repository.EmpresaRepository;
import br.com.easymoto.repository.FilialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilialService {

    private final FilialRepository filialRepository;
    private final EmpresaRepository empresaRepository;

    @Cacheable("filiais")
    public Page<FilialResponse> listar(String nome, Pageable pageable) {
        if (nome != null && !nome.isEmpty()) {
            return filialRepository.findByNomeFilialContainingIgnoreCase(nome, pageable)
                    .map(this::toResponse);
        } else {
            return filialRepository.findAll(pageable)
                    .map(this::toResponse);
        }
    }

    public FilialResponse buscarPorId(Long id) {
        Filial filial = filialRepository.findById(id).orElseThrow();
        return toResponse(filial);
    }

    @CacheEvict(value = "filiais", allEntries = true)
    public FilialResponse salvar(FilialRequest dto) {
        Empresa empresa = empresaRepository.findById(dto.empresaId()).orElseThrow();
        Filial filial = new Filial(
                null,
                dto.nomeFilial(),
                dto.cidade(),
                dto.estado(),
                dto.pais(),
                dto.endereco(),
                empresa
        );
        return toResponse(filialRepository.save(filial));
    }

    @CacheEvict(value = "filiais", allEntries = true)
    public FilialResponse atualizar(Long id, FilialRequest dto) {
        Filial filial = filialRepository.findById(id).orElseThrow();
        Empresa empresa = empresaRepository.findById(dto.empresaId()).orElseThrow();
        filial.setNomeFilial(dto.nomeFilial());
        filial.setCidade(dto.cidade());
        filial.setEstado(dto.estado());
        filial.setPais(dto.pais());
        filial.setEndereco(dto.endereco());
        filial.setEmpresa(empresa);
        return toResponse(filialRepository.save(filial));
    }

    @CacheEvict(value = "filiais", allEntries = true)
    public void deletar(Long id) {
        filialRepository.deleteById(id);
    }

    private FilialResponse toResponse(Filial filial) {
        return new FilialResponse(
                filial.getId(),
                filial.getNomeFilial(),
                filial.getCidade(),
                filial.getEstado(),
                filial.getPais(),
                filial.getEndereco(),
                filial.getEmpresa().getId(),
                filial.getEmpresa().getNomeEmpresa()
        );
    }
}
