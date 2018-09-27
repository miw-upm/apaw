package es.upm.miw.webpattern.frontcontroller;

import es.upm.miw.webpattern.http.Client;
import es.upm.miw.webpattern.http.HttpException;
import es.upm.miw.webpattern.http.HttpRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FrontControllerApiFunctionalTesting {

    private Client httpClientService;

    @BeforeEach
    void before() {
        httpClientService = new Client(new Dispatcher());
    }

    @Test
    void Resource1Method1Test() {
        HttpRequest request = HttpRequest.builder("/path1").param("param", "value").param("param2", "2").get();
        httpClientService.submit(request);
    }

    @Test
    void Resource1Method1HttpExceptionTest() {
        HttpRequest request = HttpRequest.builder("/path1").param("param", "value").param("param2", "noInteger").get();
        assertThrows(HttpException.class, () -> httpClientService.submit(request));
    }

    @Test
    void Resource1Method2Test() {
        HttpRequest request = HttpRequest.builder("/path1").post();
        httpClientService.submit(request);
    }

    @Test
    void Resource1Method3Test() {
        HttpRequest request = HttpRequest.builder("/path1/sub").post();
        httpClientService.submit(request);
    }

    @Test
    void Resource2Method1Test() {
        HttpRequest request = HttpRequest.builder("/path2").param("param", "value").get();
        httpClientService.submit(request);
    }

    @Test
    void notResourceHttpExceptionTest() {
        HttpRequest request = HttpRequest.builder("/no").param("param", "value").get();
        assertThrows(HttpException.class, () -> httpClientService.submit(request));
    }

}
