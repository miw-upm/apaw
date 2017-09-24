package es.upm.miw.pd.factoryMethod.figure;


public class FiguresManager {

    private Figure figure;

    private FigureType type;

    public void setType(FigureType type) {
        this.type = type;
    }

    public void createFigure() {
        if (this.type == FigureType.CIRCLE) {
            figure = new Circle("Circle", 1);
        } else if (this.type == FigureType.SQUARE) {
            figure = new Square("Square", 1);
        } else if (this.type == FigureType.TRIANGLE) {
            figure = new Triangle("Triangle", 1, 1);
        } else {
            assert false : "tipo figura inesperado";
        }
    }

    public Figure getFigure() {
        return figure;
    }

}
