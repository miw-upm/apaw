package es.upm.miw.pd.factoryMethod.figure.solution;

import es.upm.miw.pd.factoryMethod.figure.Circle;
import es.upm.miw.pd.factoryMethod.figure.Figure;

public class CircleCreator extends FigureCreator {

    @Override
    public Figure createFigure() {
        return new Circle("Círculo", 1);
    }

}
