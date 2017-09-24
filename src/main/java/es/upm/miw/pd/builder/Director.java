package es.upm.miw.pd.builder;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product build() {
        this.builder.buildPartA();
        this.builder.buildPartB();
        return this.builder.build();
    }

}
