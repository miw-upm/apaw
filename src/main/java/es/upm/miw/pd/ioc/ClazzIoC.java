package es.upm.miw.pd.ioc;

import org.apache.logging.log4j.LogManager;

public class ClazzIoC {

    private ReferencesFactory referencesFactory;

    // Se inyecta la referencia con este método
    public void setReferencesFactory(ReferencesFactory referencesFactory) {
        this.referencesFactory = referencesFactory;
    }

    public void method(String key) {
        LogManager.getLogger(this.getClass().getName()).info(referencesFactory.getReference(key));
    }

}
