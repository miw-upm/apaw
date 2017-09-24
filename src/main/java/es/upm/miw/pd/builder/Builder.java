package es.upm.miw.pd.builder;

public abstract class Builder {

    public abstract Builder buildPartA();

    public abstract Builder buildPartB();

    public abstract Product build();

}
