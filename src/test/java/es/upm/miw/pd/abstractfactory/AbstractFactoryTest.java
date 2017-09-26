package es.upm.miw.pd.abstractfactory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.upm.miw.pd.abstractfactory.AbstractFactory;
import es.upm.miw.pd.abstractfactory.concrete1.Concrete1Factory;
import es.upm.miw.pd.abstractfactory.concrete2.Concrete2Factory;

public class AbstractFactoryTest {

    @Test
    public void testProductAOfConcrete1Factory() {
        AbstractFactory.setAbstractFactory(new Concrete1Factory());
        assertEquals("ProductA1", AbstractFactory.getAbstractFactory().getProductA().view());
    }

    @Test
    public void testProductBOfConcrete1Factory() {
        AbstractFactory.setAbstractFactory(new Concrete1Factory());
        assertEquals("ProductB1", AbstractFactory.getAbstractFactory().getProductB().view());
    }
    
    @Test
    public void testProductAOfConcrete2Factory() {
        AbstractFactory.setAbstractFactory(new Concrete2Factory());
        assertEquals("ProductA2", AbstractFactory.getAbstractFactory().getProductA().view());
    }

    @Test
    public void testProductBOfConcrete2Factory() {
        AbstractFactory.setAbstractFactory(new Concrete2Factory());
        assertEquals("ProductB2", AbstractFactory.getAbstractFactory().getProductB().view());
    }
}
