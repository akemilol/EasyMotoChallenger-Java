package br.com.easymoto.repository;

import br.com.easymoto.model.Filial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilialRepository extends JpaRepository<Filial, Long> {
    Page<Filial> findByNomeFilialContainingIgnoreCase(String nomeFilial, Pageable pageable);
}
