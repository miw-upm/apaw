package es.upm.miw.webpattern.interceptingfilter;

import es.upm.miw.webpattern.http.Client;
import es.upm.miw.webpattern.http.HttpException;
import es.upm.miw.webpattern.http.HttpRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InterceptingFilterFunctionalTesting {

    private Client client;

    @BeforeEach
    void before() {
        this.client = new Client(new FilterManager());
    }

    @Test
    void publicPathTest() {
        HttpRequest request = HttpRequest.builder("/public").param("param", "value").get();
        this.client.submit(request);
    }

    @Test
    void publicDebugPathTest() {
        HttpRequest request = HttpRequest.builder("/public").path("/debug").param("param", "value").get();
        this.client.submit(request);
    }

    @Test
    void noPublicPathAuthorizationExceptionTest() {
        HttpRequest request = HttpRequest.builder("/noPublic").param("param", "value").get();
        assertThrows(HttpException.class, () -> this.client.submit(request));
    }


}
