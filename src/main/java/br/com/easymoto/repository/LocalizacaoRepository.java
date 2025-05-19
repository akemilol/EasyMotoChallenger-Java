package br.com.easymoto.repository;

import br.com.easymoto.model.Localizacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
    Page<Localizacao> findByStatusLocContainingIgnoreCase(String statusLoc, Pageable pageable);
}
