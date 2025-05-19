package br.com.easymoto.repository;

import br.com.easymoto.model.Patio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatioRepository extends JpaRepository<Patio, Long> {
    Page<Patio> findByNomePatioContainingIgnoreCase(String nomePatio, Pageable pageable);
}
