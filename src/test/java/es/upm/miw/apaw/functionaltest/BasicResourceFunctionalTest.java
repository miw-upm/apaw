package es.upm.miw.apaw.functionaltest;

import es.upm.miw.apaw.rest.Dto;
import es.upm.miw.apaw.rest.Gender;
import es.upm.miw.apaw.rest.UpdatingDto;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

import static es.upm.miw.apaw.rest.BasicResource.BASIC;
import static es.upm.miw.apaw.rest.BasicResource.ID_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class BasicResourceFunctionalTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl() {
        return "http://localhost:" + port + BASIC;
    }

    @Test
    void testReadByIdJson() {
        String url = baseUrl() + ID_ID;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class,"aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        LogManager.getLogger(this.getClass()).debug(() -> "GET /basic/{id}... Response: " + response.getBody());
    }

    @Test
    void testCreate() {
        Dto dto = Dto.builder().id(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000")).name("daemon")
                .gender(Gender.FEMALE).bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build();
        ResponseEntity<Dto> response = restTemplate.postForEntity(baseUrl(), dto, Dto.class);
        assertThat(response.getBody())
                .isNotNull()
                .satisfies(body -> {
                    assertThat(body.getId()).isEqualTo(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000"));
                    assertThat(body.getName()).isEqualTo("daemon");
                    assertThat(body.getGender()).isEqualTo(Gender.FEMALE);
                    assertThat(body.getBornDate()).isNotNull();
                });
    }

    @Test
    void testReadById() {
        String url = baseUrl() + ID_ID;
        ResponseEntity<Dto> response = restTemplate.getForEntity(url, Dto.class, UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000"));
        assertThat(response.getBody())
                .isNotNull()
                .satisfies(body -> {
                    assertThat(body.getId()).isEqualTo(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000"));
                    assertThat(body.getName()).isEqualTo("read");
                    assertThat(body.getGender()).isEqualTo(Gender.FEMALE);
                    assertThat(body.getBornDate()).isNotNull();
                });
    }

    @Test
    void testDelete() {
        String url = baseUrl() + ID_ID;
        ResponseEntity<Void> response = restTemplate
                .exchange(url, HttpMethod.DELETE,   HttpEntity.EMPTY, Void.class,UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000"));
        assertThat(response)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    void testUpdate() {
        String url = baseUrl() + ID_ID;
        UUID id = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000");
        Dto dto = new Dto(id, "daemon", Gender.FEMALE, LocalDateTime.now(), BigDecimal.TEN);
        ResponseEntity<Dto> response = restTemplate
                .exchange(url, HttpMethod.PUT, new HttpEntity<>(dto), Dto.class,id);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .satisfies(body -> {
                    assertThat(body.getId()).isEqualTo(id);
                    assertThat(body.getName()).isEqualTo("daemon");
                    assertThat(body.getGender()).isEqualTo(Gender.FEMALE);
                    assertThat(body.getBornDate()).isNotNull();
                });
    }

    @Test
    void testUpdateNames() {
        List<UpdatingDto> updatingDtos = List.of(new UpdatingDto(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000"), "daemon"),
                new UpdatingDto(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0001"), "daemon"));
        ResponseEntity<Dto[]> response = restTemplate.exchange(baseUrl(), HttpMethod.PATCH, new HttpEntity<>(updatingDtos), Dto[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .extracting(Dto::getName)
                .allMatch("daemon"::equals);
    }

    @Test
    void testSearch() {
        String url = baseUrl() + "?name=Miw";
        ResponseEntity<Dto[]> response = restTemplate.getForEntity(url, Dto[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .extracting(Dto::getName)
                .containsOnly("Miw");
    }
}