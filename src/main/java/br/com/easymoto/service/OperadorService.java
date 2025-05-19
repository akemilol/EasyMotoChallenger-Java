package br.com.easymoto.service;

import br.com.easymoto.dto.OperadorRequest;
import br.com.easymoto.dto.OperadorResponse;
import br.com.easymoto.model.Filial;
import br.com.easymoto.model.Operador;
import br.com.easymoto.repository.FilialRepository;
import br.com.easymoto.repository.OperadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperadorService {

    private final OperadorRepository operadorRepository;
    private final FilialRepository filialRepository;

    @Cacheable("operadores")
    public Page<OperadorResponse> listar(String nome, Pageable pageable) {
        if (nome != null && !nome.isEmpty()) {
            return operadorRepository.findByNomeOprContainingIgnoreCase(nome, pageable)
                    .map(this::toResponse);
        } else {
            return operadorRepository.findAll(pageable)
                    .map(this::toResponse);
        }
    }

    public OperadorResponse buscarPorId(Long id) {
        Operador operador = operadorRepository.findById(id).orElseThrow();
        return toResponse(operador);
    }

    @CacheEvict(value = "operadores", allEntries = true)
    public OperadorResponse salvar(OperadorRequest dto) {
        Filial filial = filialRepository.findById(dto.filialId()).orElseThrow();
        Operador operador = new Operador(
                null,
                dto.nomeOpr(),
                dto.cpfOpr(),
                dto.telefoneOpr(),
                dto.emailOpr(),
                filial
        );
        return toResponse(operadorRepository.save(operador));
    }

    @CacheEvict(value = "operadores", allEntries = true)
    public OperadorResponse atualizar(Long id, OperadorRequest dto) {
        Operador operador = operadorRepository.findById(id).orElseThrow();
        Filial filial = filialRepository.findById(dto.filialId()).orElseThrow();
        operador.setNomeOpr(dto.nomeOpr());
        operador.setCpfOpr(dto.cpfOpr());
        operador.setTelefoneOpr(dto.telefoneOpr());
        operador.setEmailOpr(dto.emailOpr());
        operador.setFilial(filial);
        return toResponse(operadorRepository.save(operador));
    }

    @CacheEvict(value = "operadores", allEntries = true)
    public void deletar(Long id) {
        operadorRepository.deleteById(id);
    }

    private OperadorResponse toResponse(Operador operador) {
        return new OperadorResponse(
                operador.getId(),
                operador.getNomeOpr(),
                operador.getCpfOpr(),
                operador.getTelefoneOpr(),
                operador.getEmailOpr(),
                operador.getFilial().getId(),
                operador.getFilial().getNomeFilial()
        );
    }
}
