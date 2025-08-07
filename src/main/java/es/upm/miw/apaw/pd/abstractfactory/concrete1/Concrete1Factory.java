package es.upm.miw.apaw.pd.abstractfactory.concrete1;

import es.upm.miw.apaw.pd.abstractfactory.AbstractFactory;
import es.upm.miw.apaw.pd.abstractfactory.ProductA;
import es.upm.miw.apaw.pd.abstractfactory.ProductB;

public class Concrete1Factory extends AbstractFactory {

    private ProductA productA;

    private ProductB productB;

    @Override
    public ProductA getProductA() {
        if (productA == null) {
            productA = new ProductA1();
        }
        return productA;
    }

    @Override
    public ProductB getProductB() {
        if (productB == null) {
            productB = new ProductB1();
        }
        return productB;
    }

    @Override
    public String toString() {
        return "FabricaConcreta1";
    }

}
