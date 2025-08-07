package es.upm.miw.apaw.pd.decorator;

public class DecoratorB extends Decorator {

    public DecoratorB(Component component) {
        super(component);
    }

    @Override
    public String view() {
        return "-----------------\n" + this.getComponent().view() + "\n-----------------";
    }
}
