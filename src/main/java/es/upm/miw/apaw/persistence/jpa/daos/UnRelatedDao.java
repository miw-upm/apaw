package es.upm.miw.apaw.persistence.jpa.daos;

import es.upm.miw.apaw.persistence.jpa.entities.UnRelatedEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UnRelatedDao extends JpaRepository<UnRelatedEntity, UUID> {
    // Consulta: por Nombre de Método
    Optional<UnRelatedEntity> findByNickIgnoreCase(String nick);

    List<UnRelatedEntity> findFirst3ByNickStartingWith(String prefix);

    List<UnRelatedEntity> findByLongerGreaterThan(Long longer, Pageable pageable);

    List<UnRelatedEntity> findByNickIn(Collection<String> values);

    // Consulta: JPQL
    // ?1 ?2 ?3...
    // :name ... @Param("name")
    @Query("select u.nick from UnRelatedEntity u where u.nick like ?1")
    List<String> findNickByNickLike(String nick);

    // Consulta: SQL
    @Query(value = "SELECT * FROM un_related_entity WHERE NICK = ?1", nativeQuery = true)
    UnRelatedEntity findByNick(String nick);

    @Query("select u from UnRelatedEntity u where " +
            "(coalesce(?1, '') = '' or u.nick like concat('%',?1,'%')) ")
    List<UnRelatedEntity> findByNickNullSave(String nick);

    @Transactional
    int deleteByNick(String nick);

    @Transactional
    int deleteByLongerGreaterThan(Long longer);

    @Modifying
    @Transactional
    @Query(value = "delete from UnRelatedEntity u where u.nick = ?1")
    void deleteByNickQuery(String nick);
}
