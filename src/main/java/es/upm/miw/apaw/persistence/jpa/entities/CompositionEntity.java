package es.upm.miw.apaw.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CompositionEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String nick;
    @Embedded
    private EmbeddableEntity embeddableEntity;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "anyEntity_id", nullable = false)
    @Singular("anyEntity")
    private List<AnyEntity> anyEntityList;
}
