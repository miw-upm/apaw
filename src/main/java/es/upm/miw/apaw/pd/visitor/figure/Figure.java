package es.upm.miw.apaw.pd.visitor.figure;

public abstract class Figure {

    private final String name;

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double area();

    public abstract double numberOfSides();

}
