package es.upm.miw.apaw.model.singleton.logger;

public class Clazz3 {
    private final Logger logger;

    public Clazz3(Logger logger) {
        this.logger = logger;
    }

    public void method1() {
        this.logger.addLog("Clazz3:method1");
    }

}
