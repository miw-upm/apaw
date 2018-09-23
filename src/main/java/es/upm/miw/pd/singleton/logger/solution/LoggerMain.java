package es.upm.miw.pd.singleton.logger.solution;

import org.apache.logging.log4j.LogManager;

public class LoggerMain {

    public static void main(String[] args) {
        new LoggerMain().run();
    }

    public void run() {
        new Clazz1().method1();
        Clazz2 c2 = new Clazz2();
        c2.method1();
        c2.method2();
        LogManager.getLogger(this.getClass()).info(Logger.getLogger().getLogs());
    }

}
