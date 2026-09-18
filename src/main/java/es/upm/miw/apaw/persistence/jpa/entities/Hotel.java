package es.upm.miw.apaw.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer categoria;

    @Column(nullable = false)
    private String direccion;

    @Embedded
    private Recepcion recepcion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    @Builder.Default
    private List<Habitacion> habitaciones = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    @Builder.Default
    private List<Empleado> empleados = new ArrayList<>();

}
