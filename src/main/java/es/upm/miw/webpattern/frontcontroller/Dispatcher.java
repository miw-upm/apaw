package es.upm.miw.webpattern.frontcontroller;

import es.upm.miw.webpattern.http.HttpRequest;
import es.upm.miw.webpattern.http.HttpResponse;
import es.upm.miw.webpattern.http.HttpStatus;
import es.upm.miw.webpattern.http.Server;

public class Dispatcher implements Server {

    private static final String PATH_ERROR = "Path Error";

    private static final String METHOD_ERROR = "Method Error";

    private static final String INTEGER_ERROR = "Integer Error";

    private Resource1 resource1;

    private Resource2 resource2;

    public Dispatcher() {
        this.resource1 = new Resource1();
        this.resource2 = new Resource2();
    }

    private void responseError(HttpResponse response, String msg) {
        response.setBody("{\"error\":\"" + msg + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    private void doGet(HttpRequest request, HttpResponse response) {
        String result;
        switch (request.getPath()) {
            case "/path1":
                // Injectar parámetros...
                try {
                    int param2 = Integer.parseInt(request.getParams().get("param2"));
                    result = resource1.method1(request.getParams().get("param"), param2);
                    response.setBody(result);
                } catch (Exception e) {
                    responseError(response, INTEGER_ERROR);
                }
                break;
            case "/path2":
                // Injectar parámetros...
                result = resource2.method1();
                response.setBody(result);
                break;
            default:
                responseError(response, PATH_ERROR);
                break;
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        String result;
        switch (request.getPath()) {
            case "/path1":
                // Injectar parámetros...
                result = resource1.method2();
                response.setBody(result);
                break;
            case "/path1/sub":
                // Injectar parámetros...
                result = resource1.method3();
                response.setBody(result);
                break;
            default:
                responseError(response, PATH_ERROR);
                break;
        }
    }

    private void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, METHOD_ERROR);
    }

    private void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, METHOD_ERROR);
    }

    private void doDelete(HttpRequest request, HttpResponse response) {
        responseError(response, METHOD_ERROR);
    }

    @Override
    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        switch (request.getMethod()) {
            case POST:
                doPost(request, response);
                break;
            case GET:
                doGet(request, response);
                break;
            case PUT:
                doPut(request, response);
                break;
            case PATCH:
                doPatch(request, response);
                break;
            case DELETE:
                doDelete(request, response);
                break;
            default:
        }
        return response;
    }

}
