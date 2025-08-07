package es.upm.miw.apaw.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//(name = "un_related_entity")
public class UnRelatedEntity {
    public static final String TRANSIENT = "no persistent";
    @Id
    private UUID id;
    @Column(unique = true, nullable = false)
    private String nick;
    private Long longer;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;
    //@Temporal(TemporalType.TIMESTAMP) //Or TemporalType.DATE: only year, month & day)
    private LocalDateTime bornDate;
    @ElementCollection(fetch = FetchType.EAGER) // @CollectionTable(name = "un_related_entity_tags")
    @Singular // builder
    private List<String> tags;
    @Transient
    private String noPersistent;
}
