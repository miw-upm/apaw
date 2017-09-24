package es.upm.miw.pd.composite.article;

import java.math.BigDecimal;

public class Article extends Product {

    private int stock;

    private BigDecimal wholesalePrice;

    public Article(int id, String reference, int stock, BigDecimal wholesalePrice) {
        super(id, reference);
        this.stock = stock;
        this.wholesalePrice = wholesalePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    @Override
    public String toString() {
        return "Article [stock=" + stock + ", wholesalePrice=" + wholesalePrice + ", " + super.toString() + "]";
    }

}
