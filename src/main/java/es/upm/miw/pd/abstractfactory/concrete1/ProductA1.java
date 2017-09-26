package es.upm.miw.pd.abstractfactory.concrete1;

import es.upm.miw.pd.abstractfactory.ProductA;

public class ProductA1 implements ProductA {

    @Override
    public String view() {
       return "ProductA1";
    }

}
