package es.upm.miw.pd.visitor;

import org.apache.logging.log4j.LogManager;

public class Visitor1 implements Visitor {

    @Override
    public void visitElementA(ElementA e) {
        LogManager.getLogger(this.getClass().getName()).info("Visitador 1 --> elemento: " + e.getAttributeA());
    }

    @Override
    public void visitElementB(ElementB e) {
        LogManager.getLogger(this.getClass().getName()).info("Visitador 1 --> elemento: " + e.getAttributeB());
    }

}
