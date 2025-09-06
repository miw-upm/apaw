package es.upm.miw.apaw.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoSearchCriteria {
    private String name;
    private Gender gender;
    private BigDecimal price;
}
