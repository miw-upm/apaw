package es.upm.miw.webpattern.interceptingfilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.miw.webpattern.http.HttpClientService;
import es.upm.miw.webpattern.http.HttpException;
import es.upm.miw.webpattern.http.HttpMethod;
import es.upm.miw.webpattern.http.HttpRequest;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InterceptingFilterFunctionalTesting {
    
    private HttpClientService httpClientService;

    @BeforeEach
    void before() {
        httpClientService= new HttpClientService(new FilterManager());
    }

    @Test
    void publicPathTest() {
        HttpRequest request = new HttpRequest("public", HttpMethod.GET);
        request.addQueryParam("param", "value");
        httpClientService.submit(request);
    }
    
    @Test
    void publicDebugPathTest() {
        HttpRequest request = new HttpRequest("public/debug", HttpMethod.GET);
        request.addQueryParam("param", "value");
        httpClientService.submit(request);
    }
    
    @Test
    void noPublicPathAuthorizationExceptionTest() {
        HttpRequest request = new HttpRequest("noPublic", HttpMethod.GET);
        request.addQueryParam("param", "value");
        assertThrows(HttpException.class, () -> httpClientService.submit(request));
    }
    
   
}
