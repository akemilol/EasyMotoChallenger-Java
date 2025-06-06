package br.com.easymoto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nome_cliente")
    private String nomeCliente;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "cpf_cliente", unique = true)
    private String cpfCliente;

    @NotBlank
    @Size(max = 15)
    @Column(name = "telefone_cliente")
    private String telefoneCliente;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "email_cliente")
    private String emailCliente;
}
