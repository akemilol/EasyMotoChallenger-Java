package br.com.easymoto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filial")
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nome_filial")
    private String nomeFilial;

    @NotBlank
    @Size(max = 50)
    @Column(name = "cidade")
    private String cidade;

    @NotBlank
    @Size(min = 2, max = 2)
    @Column(name = "estado")
    private String estado;

    @NotBlank
    @Size(max = 50)
    @Column(name = "pais")
    private String pais;

    @NotBlank
    @Size(max = 100)
    @Column(name = "endereco")
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    @NotNull
    private Empresa empresa;
}
