package es.upm.miw.apaw.persistence.mongodb.repositories;

import es.upm.miw.apaw.persistence.mongodb.documents.AggregationDocument;
import es.upm.miw.apaw.persistence.mongodb.documents.AnyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface AggregationRepository extends MongoRepository<AggregationDocument, UUID> {
    List<AggregationDocument> findByAnyDocumentListContaining(AnyDocument anyDocument);
}
