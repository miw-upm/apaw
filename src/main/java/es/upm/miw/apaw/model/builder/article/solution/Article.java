package es.upm.miw.apaw.model.builder.article.solution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Article article;

        public Builder() {
            this.article = new Article();
        }

        public Builder phone(long phone) {
            if (article.phones == null) {
                this.article.phones = new ArrayList<>();
            }
            this.article.phones.add(phone);
            return this;
        }

        public Builder reference(String reference) {
            this.article.reference = reference;
            return this;
        }

        public Builder description(String description) {
            this.article.description = description;
            return this;
        }

        public Builder retailPrice(BigDecimal retailPrice) {
            article.retailPrice = retailPrice;
            return this;
        }

        public Builder wholesalePrice(BigDecimal wholesalePrice) {
            article.wholesalePrice = wholesalePrice;
            return this;
        }

        public Builder stock(int stock) {
            article.stock = stock;
            return this;
        }

        public Builder tag(String tag) {
            if (article.tags == null) {
                this.article.tags = new ArrayList<>();
            }
            this.article.tags.add(tag);
            return this;
        }

        public Article build() {
            return this.article;
        }

    }

}
