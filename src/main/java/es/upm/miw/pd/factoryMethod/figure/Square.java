package es.upm.miw.pd.factoryMethod.figure;


public class Square extends Figure {

    public Square(String description, int side) {
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
