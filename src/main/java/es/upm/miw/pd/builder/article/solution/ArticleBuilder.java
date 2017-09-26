package es.upm.miw.pd.builder.article.solution;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.upm.miw.pd.builder.article.Article;

public class ArticleBuilder {

    private Article article;

    public ArticleBuilder(long id, long phone) {
        List<Long> phones = new ArrayList<>();
        phones.add(phone);
        this.article = new Article(id, phones);
    }

    public ArticleBuilder phone(long phone) {
        article.addPhone(phone);
        return this;
    }

    public ArticleBuilder reference(String reference) {
        article.setReference(reference);
        return this;
    }

    public ArticleBuilder description(String description) {
        article.setDescription(description);
        return this;
    }

    public ArticleBuilder retailPrice(BigDecimal retailPrice) {
        article.setRetailPrice(retailPrice);
        return this;
    }

    public ArticleBuilder wholesalePrice(BigDecimal wholesalePrice) {
        article.setWholesalePrice(wholesalePrice);
        return this;
    }

    public ArticleBuilder stock(int stock) {
        article.setStock(stock);
        return this;
    }

    public ArticleBuilder tag(String tag) {
        List<String> tags = article.getTags();
        if (tags == null) {
            tags = new ArrayList<>();
        }
        tags.add(tag);
        article.setTags(tags);
        return this;
    }

    public Article build() {
        return article;
    }

}
