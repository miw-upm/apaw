package es.upm.miw.apaw.persistence.jpa.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EmbeddableEntity {
    private Integer number;
    private String name;
}
