package es.upm.miw.pd.method_factory.solution;

import es.upm.miw.pd.method_factory.Figure;

public class FiguresManager {

    private Figure figure;
    private FigureType type;

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
        this.figure = this.type.createFigure();
    }

}
