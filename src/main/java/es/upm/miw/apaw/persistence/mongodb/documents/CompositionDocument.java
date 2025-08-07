package es.upm.miw.apaw.persistence.mongodb.documents;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class CompositionDocument {
    @Id
    private UUID id;
    private String nickname;
    private EmbeddableDocument embeddableDocument;
    private List<EmbeddableDocument> embeddableDocumentList;
}
