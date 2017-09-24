package es.upm.miw.webPattern.frontControllerApi;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.webPattern.http.HttpException;
import es.upm.miw.webPattern.http.HttpMethod;
import es.upm.miw.webPattern.http.HttpRequest;

public class FrontControllerApiFunctionalTesting {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void Resource1Method1Test() {
        HttpRequest request = new HttpRequest("path1", HttpMethod.GET);
        request.addQueryParam("param", "value");
        new HttpClientService().submit(request);
    }
    
    @Test
    public void Resource1Method2Test() {
        HttpRequest request = new HttpRequest("path1", HttpMethod.POST);
        request.addQueryParam("param", "value");
        new HttpClientService().submit(request);
    }
    
    @Test
    public void Resource1Method3Test() {
        HttpRequest request = new HttpRequest("path1/sub", HttpMethod.POST);
        request.addQueryParam("param", "value");
        new HttpClientService().submit(request);
    }

    @Test
    public void Resource2Method1Test() {
        HttpRequest request = new HttpRequest("path2", HttpMethod.GET);
        request.addQueryParam("param", "value");
        new HttpClientService().submit(request);
    }
    
    
    @Test
    public void notResourceHttpExceptionTest() {
        exception.expect(HttpException.class);
        HttpRequest request = new HttpRequest("no", HttpMethod.GET);
        request.addQueryParam("param", "value");
        new HttpClientService().submit(request);
    }
   
}
