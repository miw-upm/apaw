package es.upm.miw.apaw.functionaltests;

import es.upm.miw.apaw.rest.Dto;
import es.upm.miw.apaw.rest.Gender;
import es.upm.miw.apaw.rest.UpdatingDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static es.upm.miw.apaw.rest.BasicResource.BASIC;
import static es.upm.miw.apaw.rest.BasicResource.ID_ID;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Log4j2
class BasicResourceFunctionalTestRestTemplateFT {
    private static final UUID ID = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000");

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testCreate() {
        Dto dto = Dto.builder().id(ID).name("daemon")
                .gender(Gender.FEMALE).bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build();
        ResponseEntity<Dto> response = testRestTemplate.postForEntity(BASIC, dto, Dto.class);
        assertThat(response.getBody())
                .isNotNull()
                .satisfies(body -> {
                    assertThat(body.getId()).isEqualTo(ID);
                    assertThat(body.getName()).isEqualTo("daemon");
                    assertThat(body.getGender()).isEqualTo(Gender.FEMALE);
                    assertThat(body.getBornDate()).isNotNull();
                });
    }

    @Test
    void testReadByIdJson() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(BASIC + ID_ID, String.class, ID);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        log.debug(() -> "GET /basic/{id}... Response: " + response.getBody());
    }


    @Test
    void testReadById() {
        ResponseEntity<Dto> response = testRestTemplate.getForEntity(BASIC + ID_ID, Dto.class, ID);
        assertThat(response.getBody())
                .isNotNull()
                .satisfies(body -> {
                    assertThat(body.getId()).isEqualTo(ID);
                    assertThat(body.getName()).isEqualTo("read");
                    assertThat(body.getGender()).isEqualTo(Gender.FEMALE);
                    assertThat(body.getBornDate()).isNotNull();
                });
    }

    @Test
    void testDelete() {
        ResponseEntity<Void> response = testRestTemplate
                .exchange(BASIC + ID_ID, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class, ID);
        assertThat(response)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    void testUpdate() {
        Dto dto = new Dto(ID, "daemon", Gender.FEMALE, LocalDateTime.now(), BigDecimal.TEN);
        ResponseEntity<Dto> response = testRestTemplate
                .exchange(BASIC + ID_ID, HttpMethod.PUT, new HttpEntity<>(dto), Dto.class, ID);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .satisfies(body -> {
                    assertThat(body.getId()).isEqualTo(ID);
                    assertThat(body.getName()).isEqualTo("daemon");
                    assertThat(body.getGender()).isEqualTo(Gender.FEMALE);
                    assertThat(body.getBornDate()).isNotNull();
                });
    }

    @Test
    void testUpdateNames() {
        List<UpdatingDto> updatingDtos = List.of(new UpdatingDto(ID, "daemon"),
                new UpdatingDto(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0001"), "daemon"));
        ResponseEntity<Dto[]> response = testRestTemplate.exchange(BASIC, HttpMethod.PATCH, new HttpEntity<>(updatingDtos), Dto[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .extracting(Dto::getName)
                .allMatch("daemon"::equals);
    }

    @Test
    void testSearch() {
        ResponseEntity<Dto[]> response = testRestTemplate.getForEntity(BASIC + "?name=Miw", Dto[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .extracting(Dto::getName)
                .containsOnly("Miw");
    }
}