package es.upm.miw.apaw.pd.visitor.figure.solution;

public class Square extends Figure {

    private final double side;

    public Square(String name, double side) {
        super(name);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public void accept(FigureVisitor v) {
        v.visitSquare(this);
    }

}
