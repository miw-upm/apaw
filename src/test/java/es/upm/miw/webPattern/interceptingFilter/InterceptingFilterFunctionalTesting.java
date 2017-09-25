package es.upm.miw.webPattern.interceptingFilter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.webPattern.http.HttpClientService;
import es.upm.miw.webPattern.http.HttpException;
import es.upm.miw.webPattern.http.HttpMethod;
import es.upm.miw.webPattern.http.HttpRequest;

public class InterceptingFilterFunctionalTesting {
    
    private HttpClientService httpClientService;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void before() {
        httpClientService= new HttpClientService(new FilterManager());
    }

    @Test
    public void publicPathTest() {
        HttpRequest request = new HttpRequest("public", HttpMethod.GET);
        request.addQueryParam("param", "value");
        httpClientService.submit(request);
    }
    
    @Test
    public void publicDebugPathTest() {
        HttpRequest request = new HttpRequest("public/debug", HttpMethod.GET);
        request.addQueryParam("param", "value");
        httpClientService.submit(request);
    }
    
    @Test
    public void noPublicPathAuthorizationExceptionTest() {
        exception.expect(HttpException.class);
        HttpRequest request = new HttpRequest("noPublic", HttpMethod.GET);
        request.addQueryParam("param", "value");
        httpClientService.submit(request);
    }
    
   
}
