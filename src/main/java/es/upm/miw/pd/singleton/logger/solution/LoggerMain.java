package es.upm.miw.pd.singleton.logger.solution;

import org.apache.logging.log4j.LogManager;

public class LoggerMain {

    public void run() {
        new Clase1().method1();
        Clase2 c2 = new Clase2();
        c2.method1();
        c2.method2();
        LogManager.getLogger(this.getClass().getName()).info(Logger.getLogger().getLogs());
    }

    public static void main(String[] args) {
        new LoggerMain().run();
    }

}
