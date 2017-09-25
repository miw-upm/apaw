package es.upm.miw.pd.factorymethod.figure.solution;

import es.upm.miw.pd.factorymethod.figure.Figure;

public class FiguresManager {
    private Figure figure;

    private FigureCreator creator;

    public void setCreator(FigureCreator creator) {
        this.creator = creator;
    }

    public void createFigure() {
        this.figure = this.creator.createFigure();
    }

    public Figure getFigure() {
        return figure;
    }

}
