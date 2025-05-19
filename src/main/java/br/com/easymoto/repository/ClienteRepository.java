package br.com.easymoto.repository;

import br.com.easymoto.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Page<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente, Pageable pageable);
    boolean existsByCpfCliente(String cpfCliente);
}
