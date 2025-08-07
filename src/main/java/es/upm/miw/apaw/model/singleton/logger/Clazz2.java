package es.upm.miw.apaw.model.singleton.logger;

public class Clazz2 {

    private final Logger logger;

    public Clazz2(Logger logger) {
        this.logger = logger;
    }

    public void method1() {
        this.logger.addLog("Clazz2:method1");
    }

    public void method2() {
        Clazz3 c3 = new Clazz3(this.logger);
        c3.method1();
        this.logger.addLog("Clazz2:method2");
    }

}
