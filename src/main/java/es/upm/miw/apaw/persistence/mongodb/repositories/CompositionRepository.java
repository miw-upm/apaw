package es.upm.miw.apaw.persistence.mongodb.repositories;

import es.upm.miw.apaw.persistence.mongodb.documents.CompositionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CompositionRepository extends MongoRepository<CompositionDocument, UUID> {
}
