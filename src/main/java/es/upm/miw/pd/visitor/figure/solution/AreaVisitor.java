package es.upm.miw.pd.visitor.figure.solution;

public class AreaVisitor extends FigureVisitor {

    private double totalArea = 0;

    @Override
    public void visitCircle(Circle circle) {
        totalArea += Math.PI * circle.getRadius() * circle.getRadius();
    }

    @Override
    public void visitSquare(Square square) {
        totalArea += square.getSide() * square.getSide();
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        totalArea += triangle.getBase() * triangle.getHeight() * 0.5;
    }

    public double getTotalArea() {
        return totalArea;
    }
    
}
