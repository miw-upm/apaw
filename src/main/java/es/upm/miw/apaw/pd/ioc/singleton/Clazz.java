package es.upm.miw.apaw.pd.ioc.singleton;

import org.apache.logging.log4j.LogManager;

public class Clazz {

    public void method(String key) {
        LogManager.getLogger(this.getClass().getName()).info(ReferencesFactory.getReferencesFactory().getReference(key));
    }

}
