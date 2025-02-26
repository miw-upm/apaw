package es.upm.miw.code;

import org.apache.logging.log4j.LogManager;

public class Log4j2Demo {
    public static void main(String[] args) {
        LogManager.getLogger(Log4j2Demo.class.getName()).info("Prueba Log4j2");
    }
}
