package es.upm.miw.apaw.persistence.jpa.daos;

import es.upm.miw.apaw.persistence.jpa.entities.AggregationEntity;
import es.upm.miw.apaw.persistence.jpa.entities.AnotherEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ActiveProfiles("test")
class AnotherDaoIT {

    @Autowired
    private AggregationDao aggregationDao;

    @Autowired
    private AnotherDao anotherDao;

    @BeforeEach
    void before() {
        AnotherEntity[] anothersA = {
                AnotherEntity.builder().name("a-one").build(),
                AnotherEntity.builder().name("a-two").build()
        };
        AnotherEntity[] anothersB = {
                AnotherEntity.builder().name("b-one").build(),
                AnotherEntity.builder().name("b-two").build()
        };
        AnotherEntity anotherA = AnotherEntity.builder().name("AAA").build();
        AnotherEntity anotherB = AnotherEntity.builder().name("AAA").build();
        this.anotherDao.save(AnotherEntity.builder().name("NoAggregation").build());
        this.anotherDao.save(anotherA);
        this.anotherDao.save(anotherB);
        this.anotherDao.saveAll(Arrays.asList(anothersA));
        this.anotherDao.saveAll(Arrays.asList(anothersB));

        AggregationEntity aggregationA = AggregationEntity.builder().nick("Mi Nick A").anotherEntity(anotherA)
                .anotherEntityList(Arrays.asList(anothersA)).build();
        AggregationEntity aggregationB = AggregationEntity.builder().nick("Mi Nick B").anotherEntity(anotherB)
                .anotherEntityList(Arrays.asList(anothersB)).build();
        this.aggregationDao.save(aggregationA);
        this.aggregationDao.save(aggregationB);
    }

    @Test
    void testFindValueByAnyAggregationEntity() {
        assertFalse(anotherDao.findValueByAnyAggregationEntity().isEmpty());
    }

    @Test
    void testFindValueByAggregationEntityAnotherEntityListValue() {
        assertFalse(anotherDao.findValueByAggregationEntityAnyMatchAnotherEntityListName("b-two").isEmpty());
    }

    @AfterEach
    void delete() {
        this.aggregationDao.deleteAll();
        this.anotherDao.deleteAll();
    }

}
