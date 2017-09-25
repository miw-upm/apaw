package es.upm.miw.webpattern.http;

public class HttpException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public HttpException(String msg) {
        super(msg);
    }

}
