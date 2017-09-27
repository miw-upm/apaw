package es.upm.miw.webpattern.interceptingfilter;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.webpattern.http.HttpRequest;
import es.upm.miw.webpattern.http.HttpResponse;
import es.upm.miw.webpattern.http.HttpStatus;

public class AuthenticationFilter extends Filter {

	@Override
	public void doFilter(HttpRequest request, HttpResponse response, FilterChain filterChain) {
		// PRE-PROCESS
	    LogManager.getLogger(this.getClass().getName()).info("Authenticating pre-process...");
		if ("public".equals(request.paths()[0])) {
			// si esta autorizado se continua con la cadena de filtros
			filterChain.doFilter(request, response);
		} else {
			response.setStatus(HttpStatus.UNAUTHORIZED);
			response.addHeaderParam("auth", "AuthenticationFilter");
		}

		// POST-PROCESS
		LogManager.getLogger(this.getClass().getName()).info("Authenticating post-process...");
	}
}
