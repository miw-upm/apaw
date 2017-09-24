package es.upm.miw.webPattern.frontControllerApi;

import es.upm.miw.webPattern.http.HttpRequest;
import es.upm.miw.webPattern.http.HttpResponse;
import es.upm.miw.webPattern.http.HttpStatus;

public class Dispatcher {

    private Resource1 resource1 = new Resource1();

    private Resource2 resource2 = new Resource2();

    private void responseError(HttpResponse response, String msg) {
        response.setBody("{\"error\":\"" + msg + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        String result;
        switch (request.getPath()) {
        case "path1":
            // ConInjectar parámetros...
            result = resource1.method1(request.getParams().get("param"));
            response.setBody(result);
            break;
        case "path2":
            // Injectar parámetros...
            result = resource2.method1();
            response.setBody(result);
            break;
        default:
            responseError(response, "Path Error");
            break;
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        String result;
        switch (request.getPath()) {
        case "path1":
            // Injectar parámetros...
            result = resource1.method2();
            response.setBody(result);
            break;
        case "path1/sub":
            // Injectar parámetros...
            result = resource1.method3();
            response.setBody(result);
            break;
        default:
            responseError(response, "Path Error");
            break;
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, "Path Error");
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, "Path Error");
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        responseError(response, "Path Error");
    }

}
