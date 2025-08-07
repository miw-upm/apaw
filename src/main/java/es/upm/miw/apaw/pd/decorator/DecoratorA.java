package es.upm.miw.apaw.pd.decorator;

public class DecoratorA extends Decorator {

    public DecoratorA(Component component) {
        super(component);
    }

    @Override
    public String view() {
        return ">>> " + this.getComponent().view();
    }
}
