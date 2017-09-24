package es.upm.miw.webPattern.interceptingFilter;

import es.upm.miw.webPattern.http.HttpRequest;
import es.upm.miw.webPattern.http.HttpResponse;

public class Server {

    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        
        new FilterManager().execute(request,response);
  
        return response;
    }

}
