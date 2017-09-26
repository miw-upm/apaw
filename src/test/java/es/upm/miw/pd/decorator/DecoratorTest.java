package es.upm.miw.pd.decorator;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

public class DecoratorTest {

    @Test
    public void testDecoratorA() {
        Component component = new Component1();
        LogManager.getLogger(this.getClass().getName()).info("\n" + new DecoratorA(component).view());
    }

    @Test
    public void testDecoratorB() {
        Component component = new Component1();
        LogManager.getLogger(this.getClass().getName()).info("\n" + new DecoratorB(component).view());

    }

    @Test
    public void testDecoratorAAndB() {
        Component component = new Component1();
        Component da = new DecoratorA(component);
        LogManager.getLogger(this.getClass().getName()).info("\n" + new DecoratorB(da).view());
    }
}
