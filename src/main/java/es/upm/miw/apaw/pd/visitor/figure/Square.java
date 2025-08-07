package es.upm.miw.apaw.pd.visitor.figure;

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

}
