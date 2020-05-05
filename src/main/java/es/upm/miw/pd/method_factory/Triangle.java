package es.upm.miw.pd.method_factory;

public class Triangle extends Figure {

    private double base;

    private double height;

    public Triangle(String name, double base, double height) {
        super(name);
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return base * height * 0.5;
    }

    @Override
    public double numberOfSides() {
        return 3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                '}';
    }
}
