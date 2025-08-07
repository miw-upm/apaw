package es.upm.miw.apaw.model.builder.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private UUID id;
    private List<Long> phones;
    private String reference;
    private String description;
    private BigDecimal retailPrice;
    private Integer stock;
    private List<String> tags;
    private BigDecimal wholesalePrice;
}
