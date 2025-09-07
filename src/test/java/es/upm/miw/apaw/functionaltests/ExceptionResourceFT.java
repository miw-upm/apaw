package es.upm.miw.apaw.functionaltests;

import es.upm.miw.apaw.rest.Dto;
import es.upm.miw.apaw.rest.ExceptionResource;
import es.upm.miw.apaw.rest.Gender;
import es.upm.miw.apaw.rest.ValidatedDto;
import es.upm.miw.apaw.rest.exceptionhandler.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static es.upm.miw.apaw.rest.ExceptionResource.EXCEPTIONS;
import static es.upm.miw.apaw.rest.ExceptionResource.ID_ID;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class ExceptionResourceFT {

    private static final UUID ID =
            UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000");

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindByName() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(EXCEPTIONS)
                        .queryParam("name", "Miw")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Dto.class)
                .value(list -> {
                    assertThat(list).hasSize(3);
                    assertThat(list)
                            .extracting(Dto::getName)
                            .containsOnly("Miw");
                });
    }

    @Test
    void testFindByNameBadRequest() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(EXCEPTIONS)
                        .queryParam("name", "")
                        .build())
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testRead() {
        UUID validId = UUID.randomUUID();
        webTestClient.get()
                .uri(EXCEPTIONS + ID_ID, validId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ValidatedDto.class)
                .value(dto -> {
                    assertThat(dto.getId()).isEqualTo(validId);
                    assertThat(dto.getName()).isEqualTo("daemon");
                    assertThat(dto.getGender()).isEqualTo(Gender.FEMALE);
                    assertThat(dto.getPrice()).isEqualTo(BigDecimal.TEN);
                });
    }

    @Test
    void testReadNotFound() {
        webTestClient.get()
                .uri(EXCEPTIONS + ID_ID, ID)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ErrorMessage.class)
                .value(error -> {
                    assertThat(error.getError()).isEqualTo("NotFoundException");
                    assertThat(error.getCode()).isEqualTo(404);
                });
    }

    @Test
    void testCreate() {
        ValidatedDto dto = new ValidatedDto(
                UUID.randomUUID(),
                "daemon",
                Gender.FEMALE,
                LocalDateTime.now(),
                BigDecimal.TEN
        );

        webTestClient.post()
                .uri(EXCEPTIONS)
                .bodyValue(dto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ValidatedDto.class)
                .value(body -> {
                    assertThat(body).isNotNull();
                    assertThat(body.getId()).isEqualTo(dto.getId());
                    assertThat(body.getName()).isEqualTo(dto.getName());
                });
    }

    @Test
    void testCreateIdNullBadRequestException() {
        ValidatedDto dto = new ValidatedDto(
                null,
                "daemon",
                Gender.FEMALE,
                LocalDateTime.now().minusYears(1),
                BigDecimal.TEN
        );

        webTestClient.post()
                .uri(EXCEPTIONS)
                .bodyValue(dto)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testCreateNameBlankBadRequestException() {
        ValidatedDto dto = new ValidatedDto(
                UUID.randomUUID(),
                "   ",
                Gender.FEMALE,
                LocalDateTime.now().minusYears(1),
                BigDecimal.TEN
        );

        webTestClient.post()
                .uri(ExceptionResource.EXCEPTIONS)
                .bodyValue(dto)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testCreateBornDateFutureBadRequestException() {
        ValidatedDto dto = new ValidatedDto(
                UUID.randomUUID(),
                "daemon",
                Gender.FEMALE,
                LocalDateTime.now().plusDays(1),
                BigDecimal.TEN
        );

        webTestClient.post()
                .uri(ExceptionResource.EXCEPTIONS)
                .bodyValue(dto)
                .exchange()
                .expectStatus().isBadRequest();
    }

}

