package es.upm.miw.apaw.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AggregationEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String nick;
    @ManyToOne //@JoinColumn
    private AnotherEntity anotherEntity;
    @ManyToMany(fetch = FetchType.EAGER) //@JoinColumn
    private List<AnotherEntity> anotherEntityList;
}
