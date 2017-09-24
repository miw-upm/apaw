package es.upm.miw.pd.abstractFactory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
