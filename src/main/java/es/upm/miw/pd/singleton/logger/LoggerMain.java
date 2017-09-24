package es.upm.miw.pd.singleton.logger;

public class LoggerMain {

    public void run() {
        Logger logger = new Logger();
        new Clase1().method1(logger);
        Clase2 c2 = new Clase2(logger);
        c2.method1();
        c2.method2();
        System.out.println(logger.getLogs());
    }

    public static void main(String[] args) {
        new LoggerMain().run();
    }

}
