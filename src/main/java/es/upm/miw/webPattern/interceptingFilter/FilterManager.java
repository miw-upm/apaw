package es.upm.miw.webPattern.interceptingFilter;

import es.upm.miw.webPattern.http.HttpRequest;
import es.upm.miw.webPattern.http.HttpResponse;

public class FilterManager {

	public void execute(HttpRequest request, HttpResponse response) {
		// Se procesa el request y se establece el destino
		FilterChain filterChain = new FilterChain(new Target());

		// Se procesa el request y se establece los filtros
		// **/**
		filterChain.addFilter(new AuthenticationFilter());
		// **/public/**
		if ("public".equals(request.pathRoot(1))) {
			filterChain.addFilter(new TimeFilter());
		}
		// **/public/debug
		if ("public/debug".equals(request.getPath())) {
			filterChain.addFilter(new DebugFilter());
		}

		// Se pasa el control
		filterChain.doFilter(request, response);
	}
}
