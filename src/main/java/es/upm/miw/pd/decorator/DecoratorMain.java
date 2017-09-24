package es.upm.miw.pd.decorator;

public final class DecoratorMain {
    private DecoratorMain() {
    }

    public static void main(String[] args) {
        Component c = new Component1();
        Component da = new DecoratorA(c);
        da.view();
        new DecoratorB(c).view();
        new DecoratorB(da).view();
    }
}
