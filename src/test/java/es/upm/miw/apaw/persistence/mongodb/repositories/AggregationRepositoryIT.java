package es.upm.miw.apaw.persistence.mongodb.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.upm.miw.apaw.persistence.mongodb.documents.AggregationDocument;
import es.upm.miw.apaw.persistence.mongodb.documents.AnyDocument;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ActiveProfiles("test")
class AggregationRepositoryIT {

    @Autowired
    private AggregationRepository aggregationRepository;

    @Autowired
    private AnyRepository anyRepository;

    @BeforeEach
    void seedDb() {
        AnyDocument anyDocument = AnyDocument.builder().id(UUID.randomUUID()).value("any").build();
        List<AnyDocument> anyDocumentList = Arrays.asList(
                AnyDocument.builder().id(UUID.randomUUID()).value("any1").build(),
                AnyDocument.builder().id(UUID.randomUUID()).value("any2").build(),
                AnyDocument.builder().id(UUID.randomUUID()).value("any3").build()
        );
        this.anyRepository.save(anyDocument);
        this.anyRepository.saveAll(anyDocumentList);
        this.aggregationRepository.save(AggregationDocument.builder().id(UUID.randomUUID()).nickname("nick").anyDocument(anyDocument)
                .anyDocumentList(anyDocumentList).build());
        this.aggregationRepository.save(AggregationDocument.builder().id(UUID.randomUUID()).nickname("nick").anyDocument(anyDocument)
                .anyDocumentList(List.of(anyDocumentList.get(0), anyDocumentList.get(2))).build());
    }

    @Test
    void testNotEmpty() throws JsonProcessingException {
        List<AggregationDocument> docs = aggregationRepository.findAll();
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(docs));
        assertFalse(docs.isEmpty());
    }

    @Test
    void testFindByAnyDocumentListContaining() {
        AnyDocument any1 = anyRepository.findFirstByValue("any1");
        AnyDocument any2 = anyRepository.findFirstByValue("any2");
        assertEquals(2, aggregationRepository.findByAnyDocumentListContaining(any1).size());
        assertEquals(1, aggregationRepository.findByAnyDocumentListContaining(any2).size());
    }

    @AfterEach
    void deleteDB() {
        this.aggregationRepository.deleteAll();
        this.anyRepository.deleteAll();
    }

}
