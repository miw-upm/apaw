package es.upm.miw.webpattern.http;

public class HttpResponse extends HttpBase {

    private HttpStatus status;

    public HttpResponse() {
        this.status = HttpStatus.OK;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status.toString() + super.toString();
    }

}

