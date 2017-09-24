package es.upm.miw.pd.abstractFactory;

import org.apache.logging.log4j.LogManager;

public class ProductA1 extends AbstractProductA {

    @Override
    public void view() {
        LogManager.getLogger(this.getClass().getName()).info("ProductoA1");
    }

}
