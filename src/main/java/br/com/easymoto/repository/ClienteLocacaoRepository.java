package br.com.easymoto.repository;

import br.com.easymoto.model.ClienteLocacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteLocacaoRepository extends JpaRepository<ClienteLocacao, Long> {
    Page<ClienteLocacao> findByStatusLocacaoContainingIgnoreCase(String statusLocacao, Pageable pageable);
}
