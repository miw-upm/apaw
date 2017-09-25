package es.upm.miw.pd.factorymethod.figure.solution;

import es.upm.miw.pd.factorymethod.figure.Figure;
import es.upm.miw.pd.factorymethod.figure.Square;

public class SquareCreator extends FigureCreator {

    @Override
    public Figure createFigure() {
        return new Square("Cuadrado", 1);
    }

}
