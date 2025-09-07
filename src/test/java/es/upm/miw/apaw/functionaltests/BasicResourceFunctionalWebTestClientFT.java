package es.upm.miw.apaw.functionaltests;

import es.upm.miw.apaw.rest.Dto;
import es.upm.miw.apaw.rest.Gender;
import es.upm.miw.apaw.rest.UpdatingDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static es.upm.miw.apaw.rest.BasicResource.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
@Log4j2
class BasicResourceFunctionalWebTestClientFT {

    private static final UUID ID = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000");

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Dto dto = Dto.builder()
                .id(ID)
                .name("daemon")
                .gender(Gender.FEMALE)
                .bornDate(LocalDateTime.now())
                .price(BigDecimal.TEN)
                .build();
        EntityExchangeResult<Dto> result = webTestClient.post()
                .uri(BASIC)
                .bodyValue(dto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Dto.class)
                .returnResult();
        log.info(() -> "Código HTTP devuelto: " + result.getStatus());
        Dto body = result.getResponseBody();
        assertThat(body).isNotNull();
        assertThat(body.getId()).isEqualTo(ID);
        assertThat(body.getName()).isEqualTo("daemon");
        assertThat(body.getGender()).isEqualTo(Gender.FEMALE);
        assertThat(body.getBornDate()).isNotNull();
    }

    @Test
    void testReadByIdJson() {
        webTestClient.get()
                .uri(BASIC + ID_ID, ID)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> log.debug(() -> "GET /basic/{id}... Response: " + body)
                );
    }

    @Test
    void testReadById() {
        webTestClient.get()
                .uri(BASIC + ID_ID, ID)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Dto.class)
                .value(body -> {
                    assertThat(body).isNotNull();
                    assertThat(body.getId()).isEqualTo(ID);
                    assertThat(body.getName()).isEqualTo("read");
                    assertThat(body.getGender()).isEqualTo(Gender.FEMALE);
                    assertThat(body.getBornDate()).isNotNull();
                });
    }

    @Test
    void testReadByName() {
        String name = "daemon";
        webTestClient.get()
                .uri(BASIC + NAME + NAME_ID, name)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Dto.class)
                .value(dto -> {
                    assertThat(dto).isNotNull();
                    assertThat(dto.getId()).isNotNull();
                    assertThat(dto.getName()).isEqualTo(name);
                });
    }

    @Test
    void testDelete() {
        webTestClient.delete()
                .uri(BASIC + ID_ID, ID)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdate() {
        Dto dto = new Dto(ID, "daemon", Gender.FEMALE, LocalDateTime.now(), BigDecimal.TEN);

        webTestClient.put()
                .uri(BASIC + ID_ID, ID)
                .bodyValue(dto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Dto.class)
                .value(body -> {
                    assertThat(body).isNotNull();
                    assertThat(body.getId()).isEqualTo(ID);
                    assertThat(body.getName()).isEqualTo("daemon");
                    assertThat(body.getGender()).isEqualTo(Gender.FEMALE);
                    assertThat(body.getBornDate()).isNotNull();
                });
    }

    @Test
    void testUpdateNames() {
        List<UpdatingDto> updatingDtos = List.of(
                new UpdatingDto(ID, "daemon"),
                new UpdatingDto(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0001"), "daemon")
        );

        webTestClient.patch()
                .uri(BASIC)
                .bodyValue(updatingDtos)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Dto.class)
                .value(list -> {
                    assertThat(list).isNotNull();
                    assertThat(list)
                            .extracting(Dto::getName)
                            .allMatch("daemon"::equals);
                });
    }

    @Test
    void testSearch() {
        webTestClient.get()
                .uri(BASIC + "?name=Miw")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Dto.class)
                .value(list -> {
                    assertThat(list).isNotNull();
                    assertThat(list)
                            .extracting(Dto::getName)
                            .containsOnly("Miw");
                });
    }

    @Test
    void testSearchCriteria() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(BASIC + CRITERIA)
                        .queryParam("name", "Miw")
                        .queryParam("gender", "MALE")
                        .queryParam("price", 0)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Dto.class)
                .value(list -> assertThat(list)
                        .extracting(Dto::getName, Dto::getGender, Dto::getPrice)
                        .containsOnly(tuple("Miw", Gender.MALE, BigDecimal.ZERO)));
    }
}

