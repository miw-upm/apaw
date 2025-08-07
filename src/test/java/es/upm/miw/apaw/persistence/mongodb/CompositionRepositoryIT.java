package es.upm.miw.apaw.persistence.mongodb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.upm.miw.apaw.persistence.mongodb.documents.CompositionDocument;
import es.upm.miw.apaw.persistence.mongodb.documents.EmbeddableDocument;
import es.upm.miw.apaw.persistence.mongodb.repositories.CompositionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class CompositionRepositoryIT {

    @Autowired
    private CompositionRepository compositionRepository;

    @BeforeEach
    void seedDb() {
        CompositionDocument document1 = CompositionDocument.builder().id(UUID.randomUUID()).nickname("nick")
                .embeddableDocument(EmbeddableDocument.builder().number(1).value("1").build())
                .embeddableDocumentList(List.of(
                        EmbeddableDocument.builder().number(2).value("2").build(),
                        EmbeddableDocument.builder().number(3).value("3").build()
                )).build();
        this.compositionRepository.save(document1);
        this.compositionRepository.save(CompositionDocument.builder().id(UUID.randomUUID()).nickname("nick").build());
    }

    @Test
    void testNotEmpty() throws JsonProcessingException {
        List<CompositionDocument> docs = compositionRepository.findAll();
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(docs));
        assertFalse(docs.isEmpty());
    }

    @AfterEach
    void delete() {
        assertTrue(compositionRepository.count() > 0);
    }
}
