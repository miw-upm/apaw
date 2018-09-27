package es.upm.miw.pd.abstractfactory;

import es.upm.miw.pd.abstractfactory.concrete1.Concrete1Factory;
import es.upm.miw.pd.abstractfactory.concrete2.Concrete2Factory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractFactoryTest {

    @Test
    void testProductAOfConcrete1Factory() {
        AbstractFactory.setAbstractFactory(new Concrete1Factory());
        assertEquals("ProductA1", AbstractFactory.getAbstractFactory().getProductA().view());
    }

    @Test
    void testProductBOfConcrete1Factory() {
        AbstractFactory.setAbstractFactory(new Concrete1Factory());
        assertEquals("ProductB1", AbstractFactory.getAbstractFactory().getProductB().view());
    }

    @Test
    void testProductAOfConcrete2Factory() {
        AbstractFactory.setAbstractFactory(new Concrete2Factory());
        assertEquals("ProductA2", AbstractFactory.getAbstractFactory().getProductA().view());
    }

    @Test
    void testProductBOfConcrete2Factory() {
        AbstractFactory.setAbstractFactory(new Concrete2Factory());
        assertEquals("ProductB2", AbstractFactory.getAbstractFactory().getProductB().view());
    }
}
