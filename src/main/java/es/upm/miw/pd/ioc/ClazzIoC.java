package es.upm.miw.pd.ioc;

import org.apache.logging.log4j.LogManager;

public class ClazzIoC {

    private ReferencesFactory referencesFactory;


    public void setReferencesFactory(ReferencesFactory referencesFactory) { // Se inyecta la referencia
        this.referencesFactory = referencesFactory;
    }

    public void method(String key) {
        LogManager.getLogger(this.getClass().getName()).info(referencesFactory.getReference(key));
    }

}
