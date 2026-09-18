package es.upm.miw.apaw.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private Integer planta;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioBase;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoHabitacion tipoHabitacion;

    @ManyToMany
    @ToString.Exclude
    @Builder.Default
    private Set<Equipamiento> equipamientos = new HashSet<>();

}
