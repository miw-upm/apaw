package es.upm.miw.apaw.persistence.jpa.daos;

import es.upm.miw.apaw.persistence.jpa.entities.CompositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompositionDao extends JpaRepository<CompositionEntity, UUID> {
}
