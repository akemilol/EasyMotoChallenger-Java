package br.com.easymoto.repository;

import br.com.easymoto.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Page<Empresa> findByNomeEmpresaContainingIgnoreCase(String nomeEmpresa, Pageable pageable);
    boolean existsByCnpj(String cnpj);
}
