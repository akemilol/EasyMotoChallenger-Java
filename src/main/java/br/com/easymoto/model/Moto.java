package br.com.easymoto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moto")
    private Long id;

    @NotBlank
    @Size(max = 10)
    @Column(name = "placa", unique = true)
    private String placa;

    @NotBlank
    @Size(max = 50)
    @Column(name = "modelo")
    private String modelo;

    @NotNull
    @Column(name = "ano_fabricacao")
    private Integer anoFabricacao;

    @NotBlank
    @Size(max = 20)
    @Column(name = "status_moto")
    private String statusMoto;

    @ManyToOne
    @JoinColumn(name = "locacao_id", nullable = false)
    @NotNull
    private ClienteLocacao locacao;

    @ManyToOne
    @JoinColumn(name = "localizacao_id", nullable = false)
    @NotNull
    private Localizacao localizacao;
}
