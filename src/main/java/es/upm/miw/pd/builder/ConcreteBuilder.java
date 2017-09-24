package es.upm.miw.pd.builder;

public class ConcreteBuilder extends Builder {

    private Product product;

    @Override
    public Builder buildPartA() {
        this.product = new Product(1, 2);
        return this;
    }

    @Override
    public Builder buildPartB() {
        this.product.setAtrB1("atrB1");
        this.product.setAtrB2(2);
        return this;
    }

    @Override
    public Product build() {
        return this.product;
    }

}
