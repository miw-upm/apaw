package es.upm.miw.apaw.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping(BasicResource.BASIC)
@Log4j2
public class BasicResource {
    public static final String BASIC = "/basic";
    public static final String ID_ID = "/{id}";
    public static final String NAME = "/name";
    public static final String NAME_ID = "/{name}";
    public static final String CRITERIA = "/criteria";

    @PostMapping
    public Dto create(@RequestBody Dto dto) {
        log.info(() -> "===>>> create: " + dto);
        return dto;
    }

    @GetMapping(ID_ID)
    public Dto read(@PathVariable(value = "id") UUID id) {
        return Dto.builder()
                .id(id)
                .name("read")
                .gender(Gender.FEMALE)
                .bornDate(LocalDateTime.now())
                .price(BigDecimal.TEN).build();
    }

    @GetMapping(NAME + NAME_ID)
    public Dto readByName(@PathVariable String name) {
        return Dto.builder()
                .id(UUID.randomUUID())
                .name(name)
                .gender(Gender.FEMALE)
                .bornDate(LocalDateTime.now())
                .price(BigDecimal.TEN).build();
    }

    @PutMapping(ID_ID)
    public Dto update(@PathVariable UUID id, @RequestBody Dto dto) {
        log.info(() -> "===>>> update: " + id + ", " + dto);
        return dto;
    }

    @PutMapping(ID_ID + NAME)
    public Dto updateName(@PathVariable(value = "id") UUID id, @RequestBody Dto dto) {
        log.info(() -> "===>>> update: " + id + ", " + dto.getName());
        return Dto.builder()
                .id(id)
                .name(dto.getName())
                .gender(Gender.FEMALE)
                .bornDate(LocalDateTime.now())
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
        log.info(() -> "===>>> delete: " + id);
    }

    @GetMapping
    public Stream<Dto> findByName(@RequestParam String name) {
        return Stream.of(
                Dto.builder().id(UUID.randomUUID()).name(name).gender(Gender.MALE).bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build(),
                Dto.builder().id(UUID.randomUUID()).name(name).gender(Gender.MALE).bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build(),
                Dto.builder().id(UUID.randomUUID()).name(name).gender(Gender.MALE).bornDate(LocalDateTime.now()).price(BigDecimal.TEN).build()
        );
    }

    @GetMapping(CRITERIA)
    public Stream<Dto> findByNullSafe(@ModelAttribute DtoSearchCriteria criteria) {
        return Stream.of(
                Dto.builder().id(UUID.randomUUID()).name(criteria.getName()).gender(criteria.getGender()).bornDate(LocalDateTime.now()).price(criteria.getPrice()).build(),
                Dto.builder().id(UUID.randomUUID()).name(criteria.getName()).gender(criteria.getGender()).bornDate(LocalDateTime.now()).price(criteria.getPrice()).build(),
                Dto.builder().id(UUID.randomUUID()).name(criteria.getName()).gender(criteria.getGender()).bornDate(LocalDateTime.now()).price(criteria.getPrice()).build()
        );
    }

}
