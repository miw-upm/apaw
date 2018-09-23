package es.upm.miw.pd.singleton.logger.solution;

public class Clazz2 {

    public void method1() {
        // ...
        Logger.getLogger().addLog("Clazz2:method1");
    }

    public void method2() {
        // ...
        Clazz3 c3 = new Clazz3();
        c3.method1();
        Logger.getLogger().addLog("Clazz2:method2");
    }

}
