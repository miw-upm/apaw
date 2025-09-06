package es.upm.miw.apaw.rest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidatedDto {
    @NotNull
    private UUID id;
    @NotBlank // Not null, not empty and not only blank
    private String name;
    private Gender gender;
    @Past
    private LocalDateTime bornDate;
    private BigDecimal price;
}
