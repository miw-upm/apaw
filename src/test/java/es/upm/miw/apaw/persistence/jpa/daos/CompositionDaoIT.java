package es.upm.miw.apaw.persistence.jpa.daos;

import es.upm.miw.apaw.persistence.jpa.entities.AnyEntity;
import es.upm.miw.apaw.persistence.jpa.entities.CompositionEntity;
import es.upm.miw.apaw.persistence.jpa.entities.EmbeddableEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class CompositionDaoIT {
    @Autowired
    private CompositionDao compositionDao;
    private CompositionEntity entity;

    @BeforeEach
    void before() {
        this.entity = CompositionEntity.builder().nick("Nick")
                .embeddableEntity(EmbeddableEntity.builder().number(666).name("daemon").build())
                .anyEntity(AnyEntity.builder().name("one").build())
                .anyEntity(AnyEntity.builder().name("two").build())
                .build();
        this.compositionDao.save(entity);
    }

    @Test
    void testFindOne() {
        assertTrue(this.compositionDao.findById(entity.getId()).isPresent());
        CompositionEntity entity2 = this.compositionDao.findById(entity.getId()).get();
        assertEquals("Nick", entity2.getNick());
        assertEquals("daemon", entity2.getEmbeddableEntity().getName());
        assertEquals(2, entity2.getAnyEntityList().size());
    }

    @AfterEach
    void delete() {
        compositionDao.delete(this.entity);
    }

}
