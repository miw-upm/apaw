package es.upm.miw.pd.decorator;

import org.apache.logging.log4j.LogManager;

public class DecoratorB extends Decorator {

    public DecoratorB(Component c) {
        super(c);
    }

    @Override
    public void view() {
        LogManager.getLogger(this.getClass().getName()).info("***************");
        this.getC().view();
        LogManager.getLogger(this.getClass().getName()).info("");
        LogManager.getLogger(this.getClass().getName()).info("***************");
    }
}
