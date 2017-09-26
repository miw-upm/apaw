package es.upm.miw.pd.visitor.figure.solution;

public class NumberOfSidesVisitor extends FigureVisitor {

    private double totalNumberOfSides = 0;

    @Override
    public void visitCircle(Circle circle) {
        totalNumberOfSides += Double.POSITIVE_INFINITY;
    }

    @Override
    public void visitSquare(Square square) {
        totalNumberOfSides += 4;
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        totalNumberOfSides += 3;
    }

    public double getTotalNumberOfSides() {
        return totalNumberOfSides;
    }

}
