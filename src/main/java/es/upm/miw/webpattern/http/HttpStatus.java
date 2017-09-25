package es.upm.miw.webpattern.http;

public enum HttpStatus {
    OK(200), CREATED(201), NO_CONTENT(204), 
    BAD_REQUEST(400), UNAUTHORIZED(401), FORBIDDEN(403), NOT_FOUND(404), CONFLICT(409),
    INTERNAL_SERVER_ERROR(500);

    private int code;

    private HttpStatus(int code) {
        this.code = code;
    }

    protected int getCode() {
        return code;
    }
    
    public boolean isError() {
        return this.code >= 400;
    }

}
