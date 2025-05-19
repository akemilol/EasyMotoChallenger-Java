package br.com.easymoto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_func")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nome_func")
    private String nomeFunc;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "cpf_func", unique = true)
    private String cpfFunc;

    @NotBlank
    @Size(max = 50)
    @Column(name = "cargo")
    private String cargo;

    @NotBlank
    @Size(max = 15)
    @Column(name = "telefone_func")
    private String telefoneFunc;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "email_func")
    private String emailFunc;

    @ManyToOne
    @JoinColumn(name = "filial_id", nullable = false)
    @NotNull
    private Filial filial;
}
