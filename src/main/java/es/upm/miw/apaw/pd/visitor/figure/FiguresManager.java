package es.upm.miw.apaw.pd.visitor.figure;

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
        double result = 0;
        for (Figure figure : figures) {
            result += figure.area();
        }
        return result;
    }

    public double totalNumberOfSides() {
        double result = 0;
        for (Figure figure : figures) {
            result += figure.numberOfSides();
        }
        return result;
    }

}
