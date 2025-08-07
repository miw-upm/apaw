package es.upm.miw.apaw.persistence.jpa.daos;

import es.upm.miw.apaw.persistence.jpa.entities.AggregationEntity;
import es.upm.miw.apaw.persistence.jpa.entities.AnotherEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class AggregationDaoIT {

    @Autowired
    private AggregationDao aggregationDao;

    @Autowired
    private AnotherDao anotherDao;

    private AggregationEntity aggregationEntity;

    @BeforeEach
    void before() {
        AnotherEntity anotherEntity = AnotherEntity.builder().name("zero").build();
        List<AnotherEntity> list = Arrays.asList(
                AnotherEntity.builder().name("one").build(),
                AnotherEntity.builder().name("two").build());
        this.anotherDao.save(anotherEntity);
        this.aggregationEntity = AggregationEntity.builder().nick("Mi Nick").anotherEntity(anotherEntity)
                .anotherEntityList(list).build();
        this.anotherDao.saveAll(list);
        this.aggregationDao.save(this.aggregationEntity);
    }

    @Test
    void testFindOne() {
        assertTrue(aggregationDao.findById(aggregationEntity.getId()).isPresent());
        Assertions.assertEquals(2,
                aggregationDao.findById(aggregationEntity.getId()).get().getAnotherEntityList().size());
    }

    @Test
    void testFindNickByAnotherEntityValue() {
        assertFalse(aggregationDao.findNickByAnotherEntityName("zero").isEmpty());
        assertTrue(aggregationDao.findNickByAnotherEntityName("kk").isEmpty());
    }

    @AfterEach
    void delete() {
        this.aggregationDao.deleteAll();
        this.anotherDao.deleteAll();
    }

}
