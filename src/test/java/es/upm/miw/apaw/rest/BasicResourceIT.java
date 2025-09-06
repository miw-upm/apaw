package es.upm.miw.apaw.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.groups.Tuple.tuple;

@SpringBootTest
@ActiveProfiles("test")
class BasicResourceIT {

    private static final UUID ID = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000");
    @Autowired
    private BasicResource basicResource;

    @Test
    void testCreate() {
        Dto dto = new Dto(ID, "daemon", Gender.FEMALE, LocalDateTime.now(), BigDecimal.TEN);
        Dto result = basicResource.create(dto);
        assertThat(result)
                .usingRecursiveComparison()
                .ignoringFields("bornDate")
                .isEqualTo(dto);
    }

    @Test
    void testRead() {
        Dto result = basicResource.read(ID);
        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getName()).isEqualTo("read");
        assertThat(result.getGender()).isEqualTo(Gender.FEMALE);
        assertThat(result.getBornDate()).isNotNull();
        assertThat(result.getPrice()).isEqualTo(BigDecimal.TEN);
    }

    @Test
    void testUpdate() {
        Dto dto = new Dto(ID, "updated", Gender.FEMALE, LocalDateTime.now(), BigDecimal.ONE);
        Dto result = basicResource.update(ID, dto);
        assertThat(result)
                .usingRecursiveComparison()
                .ignoringFields("bornDate")
                .isEqualTo(dto);
    }

    @Test
    void testUpdateName() {
        Dto dto = new Dto(ID, "newName", Gender.MALE, LocalDateTime.now(), BigDecimal.ZERO);
        Dto result = basicResource.updateName(ID, dto);
        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getName()).isEqualTo("newName");
        assertThat(result.getGender()).isEqualTo(Gender.FEMALE); // siempre fija en el método
        assertThat(result.getPrice()).isEqualTo(BigDecimal.TEN);
    }

    @Test
    void testUpdateNames() {
        List<UpdatingDto> updatingDtos = List.of(
                new UpdatingDto(ID, "daemon"),
                new UpdatingDto(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0001"), "daemon")
        );
        List<Dto> result = basicResource.updateNames(updatingDtos).toList();
        assertThat(result)
                .isNotEmpty()
                .extracting(Dto::getName)
                .allMatch("daemon"::equals);
    }

    @Test
    void testDelete() {
        assertThatCode(() -> basicResource.delete(ID)).doesNotThrowAnyException();
    }

    @Test
    void testFindByName() {
        List<Dto> result = basicResource.findByName("Miw").toList();
        assertThat(result)
                .extracting(Dto::getName)
                .containsOnly("Miw");
    }

    @Test
    void testFindByNullSafe() {
        DtoSearchCriteria criteria = new DtoSearchCriteria("Miw", Gender.MALE, BigDecimal.ZERO);
        List<Dto> result = basicResource.findByNullSafe(criteria).toList();
        assertThat(result)
                .extracting(Dto::getName, Dto::getGender, Dto::getPrice)
                .containsOnly(tuple("Miw", Gender.MALE, BigDecimal.ZERO));
    }
}

