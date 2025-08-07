package es.upm.miw.apaw.pd.visitor.figure.solution;

public class Circle extends Figure {

    private final double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(FigureVisitor figureVisitor) {
        figureVisitor.visitCircle(this);
    }

}
