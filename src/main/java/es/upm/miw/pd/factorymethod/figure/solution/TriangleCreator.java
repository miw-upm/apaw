package es.upm.miw.pd.factorymethod.figure.solution;

import es.upm.miw.pd.factorymethod.figure.Figure;
import es.upm.miw.pd.factorymethod.figure.Triangle;

public class TriangleCreator extends FigureCreator {

    @Override
    public Figure createFigure() {
        return new Triangle("Triangulo", 1, 1);
    }

}
