package es.upm.miw.pd.singleton.logger;

public class Clase3 {
    private Logger logger;

    public Clase3(Logger logger) {
        this.logger = logger;
    }

    public void method1() {
        // ...
        this.logger.addLog("Clase3:method1");
    }

}
