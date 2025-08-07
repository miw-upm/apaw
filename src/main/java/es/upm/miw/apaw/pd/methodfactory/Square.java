package es.upm.miw.apaw.pd.methodfactory;

public class Square extends Figure {

    private final double side;

    public Square(String name, double side) {
        super(name);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double numberOfSides() {
        return 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
