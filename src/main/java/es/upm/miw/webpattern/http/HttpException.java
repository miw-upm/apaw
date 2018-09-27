package es.upm.miw.webpattern.http;

public class HttpException extends RuntimeException {
    private static final long serialVersionUID = 7271728903247259709L;

    private HttpStatus httpStatus;

    public HttpException(HttpStatus httpStatus, String msg) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
