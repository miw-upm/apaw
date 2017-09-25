package es.upm.miw.webpattern.http;

public interface Server {
    HttpResponse submit(HttpRequest request);
}
