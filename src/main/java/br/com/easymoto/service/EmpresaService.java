package br.com.easymoto.service;

import br.com.easymoto.dto.EmpresaRequest;
import br.com.easymoto.dto.EmpresaResponse;
import br.com.easymoto.model.Empresa;
import br.com.easymoto.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repository;

    @Cacheable("empresas")
    public Page<EmpresaResponse> listar(String nome, Pageable pageable) {
        if (nome != null && !nome.isEmpty()) {
            return repository.findByNomeEmpresaContainingIgnoreCase(nome, pageable)
                    .map(this::toResponse);
        } else {
            return repository.findAll(pageable)
                    .map(this::toResponse);
        }
    }

    public EmpresaResponse buscarPorId(Long id) {
        Empresa empresa = repository.findById(id).orElseThrow();
        return toResponse(empresa);
    }

    @CacheEvict(value = "empresas", allEntries = true)
    public EmpresaResponse salvar(EmpresaRequest dto) {
        Empresa empresa = new Empresa(null,
                dto.nomeEmpresa(),
                dto.cnpj()
        );
        return toResponse(repository.save(empresa));
    }

    @CacheEvict(value = "empresas", allEntries = true)
    public EmpresaResponse atualizar(Long id, EmpresaRequest dto) {
        Empresa empresa = repository.findById(id).orElseThrow();
        empresa.setNomeEmpresa(dto.nomeEmpresa());
        empresa.setCnpj(dto.cnpj());
        return toResponse(repository.save(empresa));
    }

    @CacheEvict(value = "empresas", allEntries = true)
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private EmpresaResponse toResponse(Empresa empresa) {
        return new EmpresaResponse(
                empresa.getId(),
                empresa.getNomeEmpresa(),
                empresa.getCnpj()
        );
    }
}
