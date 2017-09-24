package es.upm.miw.pd.factoryMethod.figure.solution;

import es.upm.miw.pd.factoryMethod.figure.Figure;
import es.upm.miw.pd.factoryMethod.figure.Square;

public class SquareCreator extends FigureCreator {

    @Override
    public Figure createFigure() {
        return new Square("Cuadrado", 1);
    }

}
