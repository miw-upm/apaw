package es.upm.miw.pd.factoryMethod.figure.solution;

import es.upm.miw.pd.factoryMethod.figure.Figure;
import es.upm.miw.pd.factoryMethod.figure.Triangle;

public class TriangleCreator extends FigureCreator {

    @Override
    public Figure createFigure() {
        return new Triangle("Triangulo", 1, 1);
    }

}
