package br.com.easymoto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    @NotBlank
    @Size(min = 14, max = 14)
    @Column(name = "cnpj", unique = true)
    private String cnpj;
}
