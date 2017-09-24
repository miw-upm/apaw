package es.upm.miw.pd.singleton.logger.solution;

public class LoggerMain {

    public void run() {
        new Clase1().method1();
        Clase2 c2 = new Clase2();
        c2.method1();
        c2.method2();
        System.out.println(Logger.getLogger().getLogs());
    }

    public static void main(String[] args) {
        new LoggerMain().run();
    }

}
