package es.upm.miw.pd.abstractfactory;

public abstract class AbstractFactory {
    private static AbstractFactory abstractFactory;
    
    public static AbstractFactory getAbstractFactory() {
        return abstractFactory;
    }

    public static void setAbstractFactory(AbstractFactory abstractFactory) {
        AbstractFactory.abstractFactory = abstractFactory;
    }

    public abstract ProductA getProductA();

    public abstract ProductB getProductB();
}
