package es.upm.miw.webpattern.http;

public class HttpException extends RuntimeException {
    private static final long serialVersionUID = 7408093310374440283L;

    public HttpException(String msg) {
        super(msg);
    }

}
