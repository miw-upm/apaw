package es.upm.miw.webpattern.interceptingfilter;

import es.upm.miw.webpattern.http.HttpRequest;
import es.upm.miw.webpattern.http.HttpResponse;

public interface Filter {
   void doFilter(HttpRequest request, HttpResponse response, FilterChain filterChain);
}
