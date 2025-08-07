package es.upm.miw.apaw.persistence.jpa.daos;

import es.upm.miw.apaw.persistence.jpa.entities.AnotherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AnotherDao extends JpaRepository<AnotherEntity, UUID> {
    @Query("SELECT anotherList.name FROM AggregationEntity agg JOIN agg.anotherEntityList anotherList")
    List<String> findValueByAnyAggregationEntity();

    @Query("SELECT another.name FROM AggregationEntity agg " +
            "JOIN agg.anotherEntity another " +
            "JOIN agg.anotherEntityList anotherList WHERE anotherList.name = ?1")
    List<String> findValueByAggregationEntityAnyMatchAnotherEntityListName(String name);
}
