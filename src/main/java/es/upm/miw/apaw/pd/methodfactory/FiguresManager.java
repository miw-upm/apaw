package es.upm.miw.apaw.pd.methodfactory;

public class FiguresManager {

    private final FigureType type;
    private Figure figure;

    public FiguresManager(FigureType type) {
        this.type = type;
    }

    public Figure getFigure() {
        return figure;
    }

    public FigureType getType() {
        return type;
    }

    public void createFigure() {
        if (this.type == FigureType.CIRCLE) {
            this.figure = new Circle("Circle", 1);
        } else if (this.type == FigureType.SQUARE) {
            this.figure = new Square("Square", 1);
        } else if (this.type == FigureType.TRIANGLE) {
            this.figure = new Triangle("Triangle", 1, 1);
        } else {
            assert false : "unexpected";
        }
    }

    @Override
    public String toString() {
        return "FiguresManager{" +
                "figure=" + figure +
                ", type=" + type +
                '}';
    }
}
