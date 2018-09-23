package es.upm.miw.pd.singleton.logger;

public class Clazz3 {
    private Logger logger;

    public Clazz3(Logger logger) {
        this.logger = logger;
    }

    public void method1() {
        // ...
        this.logger.addLog("Clazz3:method1");
    }

}
