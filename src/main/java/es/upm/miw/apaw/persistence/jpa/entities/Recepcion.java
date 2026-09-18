package es.upm.miw.apaw.persistence.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recepcion {

    @Column(nullable = false)
    private LocalTime horarioApertura;

    @Column(nullable = false)
    private Integer numeroMostradores;

}
