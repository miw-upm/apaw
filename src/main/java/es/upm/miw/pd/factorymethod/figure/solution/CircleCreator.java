package es.upm.miw.pd.factorymethod.figure.solution;

import es.upm.miw.pd.factorymethod.figure.Circle;
import es.upm.miw.pd.factorymethod.figure.Figure;

public class CircleCreator extends FigureCreator {

    @Override
    public Figure createFigure() {
        return new Circle("Círculo", 1);
    }

}
