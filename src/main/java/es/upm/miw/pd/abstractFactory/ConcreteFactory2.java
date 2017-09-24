package es.upm.miw.pd.abstractFactory;

public class ConcreteFactory2 extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }

    @Override
    public String toString() {
        return "FabricaConcreta2";
    }

}
