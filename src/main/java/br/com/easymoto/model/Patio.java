package br.com.easymoto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patio")
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nome_patio")
    private String nomePatio;

    @NotBlank
    @Size(max = 50)
    @Column(name = "tamanho_patio")
    private String tamanhoPatio;

    @NotBlank
    @Size(max = 1)
    @Column(name = "andar")
    private String andar;

    @ManyToOne
    @JoinColumn(name = "filial_id", nullable = false)
    @NotNull
    private Filial filial;
}
