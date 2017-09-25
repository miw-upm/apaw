package es.upm.miw.pd.singleton.logger.solution;

public class Clase2 {

    public void method1() {
        // ...
        Logger.getLogger().addLog("Clase2:method1");
    }

    public void method2() {
        // ...
        Clase3 c3 = new Clase3();
        c3.method1();
        Logger.getLogger().addLog("Clase2:method2");
    }

}
