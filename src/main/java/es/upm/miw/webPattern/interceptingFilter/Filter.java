package es.upm.miw.webPattern.interceptingFilter;

import es.upm.miw.webPattern.http.HttpRequest;
import es.upm.miw.webPattern.http.HttpResponse;

public abstract class Filter {
	public abstract void doFilter(HttpRequest request, HttpResponse response, FilterChain filterChain);
}
