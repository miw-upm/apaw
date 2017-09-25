package es.upm.miw.pd.abstractfactory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.pd.abstractfactory.AbstractFactory;
import es.upm.miw.pd.abstractfactory.ConcreteFactory1;

public class AbstractFactoryTest {

    private AbstractFactory abstractFactory;
    
    @Before
    public void before() {
        abstractFactory = new ConcreteFactory1();
    }
    
    @Test
    public void testProductA() {
        assertEquals("ProductA1",abstractFactory.createProductA().view());
    }
    
    @Test
    public void testProductB() {
        assertEquals("ProductB1",abstractFactory.createProductB().view());
    }
}
