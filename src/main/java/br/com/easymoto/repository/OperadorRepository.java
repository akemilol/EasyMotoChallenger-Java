package br.com.easymoto.repository;

import br.com.easymoto.model.Operador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
    Page<Operador> findByNomeOprContainingIgnoreCase(String nomeOpr, Pageable pageable);
    boolean existsByCpfOpr(String cpfOpr);
}
