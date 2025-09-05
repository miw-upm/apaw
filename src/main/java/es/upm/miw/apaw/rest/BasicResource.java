package es.upm.miw.apaw.rest;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping(BasicResource.BASIC)
public class BasicResource {
    public static final String BASIC = "/basic";
    public static final String ID_ID = "/{id}";
    public static final String NAME = "/name";
    public static final String SEARCH = "/search";

    @PostMapping
    public Dto create(@RequestBody Dto dto) {
        LogManager.getLogger(this.getClass()).info(() -> "===>>> create: " + dto);
        return dto;
    }

    @GetMapping(ID_ID)
    public Dto read(@PathVariable(value = "id") UUID id) {
        return Dto.builder()
                .id(id)
                .name("read")
                .gender( Gender.FEMALE)
                .bornDate( LocalDateTime.now())
                .price(BigDecimal.TEN).build();
    }

    @PutMapping(ID_ID)
    public Dto update(@PathVariable UUID id, @RequestBody Dto dto) {
        LogManager.getLogger(this.getClass()).info(() -> "===>>> update: " + id + ", " + dto);
        return dto;
    }

    @PutMapping(ID_ID + NAME)
    public Dto updateName(@PathVariable(value = "id") UUID id, @RequestBody Dto dto) {
        LogManager.getLogger(this.getClass()).info(() -> "===>>> update: " + id + ", " + dto.getName());
        return Dto.builder()
                .id(id)
                .name(dto.getName())
                .gender( Gender.FEMALE)
                .bornDate( LocalDateTime.now())
                .price(BigDecimal.TEN).build();
    }

    @PatchMapping
    public Stream<Dto> updateNames(@RequestBody List<UpdatingDto> updatingNames) {
        return updatingNames.stream()
                .map(updatingDto -> Dto.builder().id(updatingDto.getId()).name(updatingDto.getName())
                        .gender(Gender.FEMALE).bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build());
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable UUID id) {
        LogManager.getLogger(this.getClass()).info(() -> "===>>> delete: " + id);
    }

    @GetMapping
    public Stream<Dto> findByName(@RequestParam String name) {
        return Stream.of(
                Dto.builder().id(UUID.randomUUID()).name(name).gender(Gender.MALE).bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build(),
                Dto.builder().id(UUID.randomUUID()).name(name).gender(Gender.MALE).bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build(),
                Dto.builder().id(UUID.randomUUID()).name(name).gender(Gender.MALE).bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build()
        );
    }
}
