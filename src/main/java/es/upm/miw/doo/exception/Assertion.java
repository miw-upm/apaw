package es.upm.miw.doo.exception;

public class Assertion {

    public void parameter(int x) {
        assert x >= 0 : "x debe se >= 0";
    }

    public void defaultIf(int x) {
        if (x == 0) {
            x++;
        } else if (x == 1) {
            x--;
        } else
            assert false : "valor de x inesperado";
    }

    public void checkCode(int x) {
        int y = x++ + 2;
        assert y == 2 : "inesperado, y debería ser 2";
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
