package es.upm.miw.pd.visitor.figure.solution;

import java.util.List;

public abstract class FigureVisitor {

    public abstract void visitCircle(Circle circle);

    public abstract void visitSquare(Square square);

    public abstract void visitTriangle(Triangle triangle);

    public void process(List<Figure> figures) {
        for (Figure figure : figures) {
            figure.accept(this);
        }
    }

}
