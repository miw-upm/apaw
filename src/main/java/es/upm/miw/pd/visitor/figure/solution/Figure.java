package es.upm.miw.pd.visitor.figure.solution;

public abstract class Figure {

    private String name;

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void accept(FigureVisitor figureVisitor);

}
