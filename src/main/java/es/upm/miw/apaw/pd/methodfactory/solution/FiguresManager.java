package es.upm.miw.apaw.pd.methodfactory.solution;

import es.upm.miw.apaw.pd.methodfactory.Figure;

public class FiguresManager {

    private final FigureType type;
    private Figure figure;

    public FiguresManager(FigureType type) {
        this.type = type;
    }

    public Figure getFigure() {
        return this.figure;
    }

    public FigureType getType() {
        return this.type;
    }

    public void createFigure() {
        this.figure = this.type.createFigure();
    }

}
