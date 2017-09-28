package es.upm.miw.webpattern.frontcontroller;

public class Resource1 {

    public String method1(String param, int param2) {
        return "{\"name\":\"Resource1:method1:" + param + "," + param2 + "\"}";
    }

    public String method2() {
        return "{\"name\":\"Resource1:method2:\"}";
    }

    public String method3() {
        return "{\"name\":\"Resource1:method3\"}";
    }

}
