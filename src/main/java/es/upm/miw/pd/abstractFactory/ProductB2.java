package es.upm.miw.pd.abstractFactory;

import org.apache.logging.log4j.LogManager;

public class ProductB2 extends AbstractProductB {

    @Override
    public void view() {
        LogManager.getLogger(this.getClass().getName()).info("ProductoB2");
    }

}
