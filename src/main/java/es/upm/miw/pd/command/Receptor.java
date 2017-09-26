package es.upm.miw.pd.command;

import org.apache.logging.log4j.LogManager;

public class Receptor {
    
    public void action1() {
        LogManager.getLogger(this.getClass().getName()).info("Acción 1");
    }

    public void action2() {
        LogManager.getLogger(this.getClass().getName()).info("Acción 2");
    }
}
