package br.com.easymoto.repository;

import br.com.easymoto.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Page<Funcionario> findByNomeFuncContainingIgnoreCase(String nomeFunc, Pageable pageable);
    boolean existsByCpfFunc(String cpfFunc);
}
