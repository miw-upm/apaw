package es.upm.miw.apaw.pd.methodfactory.solution;

import es.upm.miw.apaw.pd.methodfactory.Circle;
import es.upm.miw.apaw.pd.methodfactory.Figure;
import es.upm.miw.apaw.pd.methodfactory.Square;
import es.upm.miw.apaw.pd.methodfactory.Triangle;

import java.util.function.Supplier;

public enum FigureType {
    CIRCLE(() -> new Circle("Circle", 1)),
    SQUARE(() -> new Square("Square", 1)),
    TRIANGLE(() -> new Triangle("Triangle", 1, 1));

    private final Supplier<Figure> figureCreator;

    FigureType(Supplier<Figure> figureCreator) {
        this.figureCreator = figureCreator;
    }

    public Figure createFigure() {
        return this.figureCreator.get();
    }
}
