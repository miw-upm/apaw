package es.upm.miw.webpattern.frontcontroller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.miw.webpattern.http.HttpClientService;
import es.upm.miw.webpattern.http.HttpException;
import es.upm.miw.webpattern.http.HttpMethod;
import es.upm.miw.webpattern.http.HttpRequest;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FrontControllerApiFunctionalTesting {

    private HttpClientService httpClientService;

    @BeforeEach
    void before() {
        httpClientService = new HttpClientService(new Dispatcher());
    }

    @Test
    void Resource1Method1Test() {
        HttpRequest request = new HttpRequest("path1", HttpMethod.GET);
        request.addQueryParam("param", "value");
        request.addQueryParam("param2", "2");
        httpClientService.submit(request);
    }
    
    @Test
    void Resource1Method1HttpExceptionTest() {
        HttpRequest request = new HttpRequest("path1", HttpMethod.GET);
        request.addQueryParam("param", "value");
        request.addQueryParam("param2", "noInteger");
        assertThrows(HttpException.class, () -> httpClientService.submit(request));
    }

    @Test
    void Resource1Method2Test() {
        HttpRequest request = new HttpRequest("path1", HttpMethod.POST);
        httpClientService.submit(request);
    }

    @Test
    void Resource1Method3Test() {
        HttpRequest request = new HttpRequest("path1/sub", HttpMethod.POST);
        httpClientService.submit(request);
    }

    @Test
    void Resource2Method1Test() {
        HttpRequest request = new HttpRequest("path2", HttpMethod.GET);
        request.addQueryParam("param", "value");
        httpClientService.submit(request);
    }

    @Test
    void notResourceHttpExceptionTest() {
        HttpRequest request = new HttpRequest("no", HttpMethod.GET);
        request.addQueryParam("param", "value");
        assertThrows(HttpException.class, () -> httpClientService.submit(request));
    }

}
