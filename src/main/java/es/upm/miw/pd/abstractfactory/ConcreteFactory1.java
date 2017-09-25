package es.upm.miw.pd.abstractfactory;

public class ConcreteFactory1 extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }

    @Override
    public String toString() {
        return "FabricaConcreta1";
    }

}
