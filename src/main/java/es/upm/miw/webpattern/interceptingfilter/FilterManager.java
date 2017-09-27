package es.upm.miw.webpattern.interceptingfilter;

import es.upm.miw.webpattern.http.HttpRequest;
import es.upm.miw.webpattern.http.HttpResponse;
import es.upm.miw.webpattern.http.Server;

public class FilterManager implements Server {

    public void execute(HttpRequest request, HttpResponse response) {
        // Se procesa el request y se establece el destino
        FilterChain filterChain = new FilterChain(new Target());

        // Se procesa el request y se establece los filtros
        // **/**
        filterChain.addFilter(new AuthenticationFilter());
        // **/public/**
        if ("public".equals(request.paths()[0])) {
            filterChain.addFilter(new TimeFilter());
        }
        // **/public/debug
        if ("public/debug".equals(request.getPath())) {
            filterChain.addFilter(new DebugFilter());
        }

        // Se pasa el control
        filterChain.doFilter(request, response);
    }

    @Override
    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        this.execute(request, response);
        return response;
    }
}
