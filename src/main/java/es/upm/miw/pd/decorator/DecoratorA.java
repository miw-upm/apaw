package es.upm.miw.pd.decorator;

import org.apache.logging.log4j.LogManager;

public class DecoratorA extends Decorator {

    public DecoratorA(Component c) {
        super(c);
    }

    @Override
    public void view() {
        LogManager.getLogger(this.getClass().getName()).info(">>> ");
        this.getC().view();
    }
}
