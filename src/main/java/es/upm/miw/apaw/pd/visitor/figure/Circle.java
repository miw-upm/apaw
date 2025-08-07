package es.upm.miw.apaw.pd.visitor.figure;

public class Circle extends Figure {

    private final double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double numberOfSides() {
        return Double.POSITIVE_INFINITY;
    }

}
