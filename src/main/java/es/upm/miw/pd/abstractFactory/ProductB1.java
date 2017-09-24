package es.upm.miw.pd.abstractFactory;

import org.apache.logging.log4j.LogManager;

public class ProductB1 extends AbstractProductB {

    @Override
    public void view() {
        LogManager.getLogger(this.getClass().getName()).info("ProductoB1");
    }

}
