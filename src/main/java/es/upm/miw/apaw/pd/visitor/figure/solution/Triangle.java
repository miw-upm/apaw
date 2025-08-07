package es.upm.miw.apaw.pd.visitor.figure.solution;

public class Triangle extends Figure {
    private final double base;

    private final double height;

    public Triangle(String description, double base, double height) {
        super(description);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void accept(FigureVisitor v) {
        v.visitTriangle(this);
    }

}
