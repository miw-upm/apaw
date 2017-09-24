package es.upm.miw.pd.factoryMethod.figure;


public class Triangle extends Figure {
    public Triangle(String description, int base, int height) {
        super(description);
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double numberOfSides() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
