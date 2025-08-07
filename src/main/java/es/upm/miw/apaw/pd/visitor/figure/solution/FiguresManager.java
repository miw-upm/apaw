package es.upm.miw.apaw.pd.visitor.figure.solution;

import java.util.ArrayList;
import java.util.List;

public class FiguresManager {

    private final List<Figure> figures;

    public FiguresManager() {
        figures = new ArrayList<>();
    }

    public void add(Figure figure) {
        figures.add(figure);
    }

    public double totalArea() {
        AreaVisitor areaVisitor = new AreaVisitor();
        areaVisitor.process(figures);
        return areaVisitor.getTotalArea();
    }

    public double totalNumberOfSides() {
        NumberOfSidesVisitor numberOfSidesVisitor = new NumberOfSidesVisitor();
        numberOfSidesVisitor.process(figures);
        return numberOfSidesVisitor.getTotalNumberOfSides();
    }


}
