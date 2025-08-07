package es.upm.miw.apaw.persistence.mongodb.repositories;

import es.upm.miw.apaw.persistence.mongodb.documents.AnyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AnyRepository extends MongoRepository<AnyDocument, UUID> {
    AnyDocument findFirstByValue(String value);
}
