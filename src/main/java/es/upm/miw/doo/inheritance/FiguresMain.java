package es.upm.miw.doo.inheritance;

public class FiguresMain {

    public static void main(String[] args) {
        FiguresHandler fh = new FiguresHandler();
        fh.addFigure(new Square("c1", 2));
        fh.addFigure(new Square("c2", 3));
        fh.addFigure(new Triangle("t1", 2, 3));

        System.out.println(fh.toString());

        System.out.println("Area total:" + fh.area());
        System.out.println("Numero total de lados:" + fh.sides());
    }

}
