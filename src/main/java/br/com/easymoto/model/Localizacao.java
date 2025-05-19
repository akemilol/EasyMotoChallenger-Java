package br.com.easymoto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localizacao")
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "status_loc")
    private String statusLoc;

    @NotNull
    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @NotBlank
    @Size(max = 50)
    @Column(name = "zona_virtual")
    private String zonaVirtual;

    @NotNull
    @Column(name = "latitude")
    private Double latitude;

    @NotNull
    @Column(name = "longitude")
    private Double longitude;
}
