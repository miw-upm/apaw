package es.upm.miw.apaw.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoWithValidations {
    private UUID id;
    @NotNull
    @NotBlank
    @Pattern(regexp = "\\d{9}")
    private String mobile;
    @NotNull
    @NotBlank
    private String firstName;
}
