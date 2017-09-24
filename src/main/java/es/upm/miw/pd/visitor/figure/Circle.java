package es.upm.miw.pd.visitor.figure;

public class Circle extends Figure {

    private double radius;

    public Circle(String description, double radius) {
        super(description);
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
