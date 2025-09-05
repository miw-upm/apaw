package es.upm.miw.apaw.rest;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatingDto {
    private UUID id;
    private String name;
}
