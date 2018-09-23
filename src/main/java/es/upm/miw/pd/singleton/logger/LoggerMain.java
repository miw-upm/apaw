package es.upm.miw.pd.singleton.logger;

import org.apache.logging.log4j.LogManager;

public class LoggerMain {

    public static void main(String[] args) {
        new LoggerMain().run();
    }

    public void run() {
        Logger logger = new Logger();
        new Clazz1().method1(logger);
        Clazz2 c2 = new Clazz2(logger);
        c2.method1();
        c2.method2();
        LogManager.getLogger(this.getClass().getName()).info(logger.getLogs());
    }

}
