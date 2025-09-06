package es.upm.miw.apaw.rest;


import es.upm.miw.apaw.rest.exceptionhandler.ErrorMessage;
import es.upm.miw.apaw.rest.exceptionhandler.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping(ExceptionResource.EXCEPTIONS)
public class ExceptionResource {

    public static final String EXCEPTIONS = "/exceptions";
    public static final String ID_ID = "/{id}";

    @GetMapping
    public ResponseEntity<Object> findByName(@RequestParam String name) {
        if (name == null || name.isBlank()) {
            IllegalArgumentException ex =
                    new IllegalArgumentException("El parámetro 'name' no puede estar vacío");

            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorMessage(ex, HttpStatus.BAD_REQUEST.value()));
        }

        List<Dto> result = Stream.of(
                Dto.builder().id(UUID.randomUUID()).name(name).gender(Gender.MALE)
                        .bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build(),
                Dto.builder().id(UUID.randomUUID()).name(name).gender(Gender.MALE)
                        .bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build(),
                Dto.builder().id(UUID.randomUUID()).name(name).gender(Gender.MALE)
                        .bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build()
        ).toList();

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }


    @GetMapping(ID_ID)
    public ValidatedDto read(@PathVariable UUID id) {
        if (id.equals(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000"))) {
            throw new NotFoundException("id:" + id);
        }
        return new ValidatedDto(id, "daemon", Gender.FEMALE, LocalDateTime.now(), BigDecimal.TEN);
    }

    @PostMapping
    public ValidatedDto create(@Valid @RequestBody ValidatedDto dto) {
        return dto;
    }
}