package es.upm.miw.doo.exception;

import org.apache.logging.log4j.LogManager;

public class Assertion {

    public void parameter(int x) {
        assert x >= 0 : "x debe se >= 0";
    }

    public void defaultIf(int x) {
        if (x == 0) {
            LogManager.getLogger(this.getClass().getName()).info(x);
        } else if (x == 1) {
            LogManager.getLogger(this.getClass().getName()).info(x);
        } else
            assert false : "valor de x inesperado";
    }

    public void checkCode(int x) {
        x *= 2;
        assert x % 2 == 0 : "inesperado, x debería ser par";
    }

    public void unreachableCode() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                return;
            }
        }
        assert false : "No debieramos estar aquí";
    }

}
