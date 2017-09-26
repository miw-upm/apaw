package es.upm.miw.pd.visitor.figure;

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

}
