package es.upm.miw.apaw.persistence.jpa.daos;

import es.upm.miw.apaw.persistence.jpa.entities.AggregationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AggregationDao extends JpaRepository<AggregationEntity, UUID> {
    @Query("SELECT agg.nick FROM AggregationEntity agg WHERE agg.anotherEntity.name = ?1")
    List<String> findNickByAnotherEntityName(String name);
}
