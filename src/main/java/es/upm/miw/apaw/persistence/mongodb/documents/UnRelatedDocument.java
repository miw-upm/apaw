package es.upm.miw.apaw.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document //(collection = "unrelated_documents")
public class UnRelatedDocument {
    public static final String TRANSIENT = "no persistent";
    @Id //El valor no nos importa. No hay razón para cambiarlo
    private UUID id;
    @Indexed(unique = true)
    private String nickname;
    private Gender gender; // String
    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) //ISO 8601 format, e.g., 2000-01-01T10:15:30
    private LocalDateTime dateOfBirth;
    private String[] tags;
    private String large;
    @Field("is_active") //cambia el nombre del campo
    private Boolean active;
    private Integer integer;
    private Long longer;
    private Double decimal;
    @Transient
    private String noPersistent;
}
