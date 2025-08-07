package es.upm.miw.apaw.model;

import lombok.*;

import java.util.List;

@Builder
@Data  // @ToString, @EqualsAndHashCode, @Getter, and @Setter on all non-final fields, @RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class DtoWithLombok {
    @EqualsAndHashCode.Include // only id
    private String id; //@Setter(AccessLevel.NONE) for exceptions
    private String name;
    private String surName;
    private String email;
    @Singular // .tag().tag().tag()
    private List<String> tags;
}
