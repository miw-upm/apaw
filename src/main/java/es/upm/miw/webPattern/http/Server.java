package es.upm.miw.webPattern.http;

public interface Server {
    HttpResponse submit(HttpRequest request);
}
