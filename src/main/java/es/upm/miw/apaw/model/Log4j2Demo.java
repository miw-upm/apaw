package es.upm.miw.apaw.model;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Log4j2Demo {
    public static void main(String[] args) {
        log.debug("Debug Log4j2");
        log.info("Info Log4j2");
        log.warn("Warning Log4j2");
        log.error("Error Log4j2");
    }
}
