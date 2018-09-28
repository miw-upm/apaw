package es.upm.miw.webpattern.interceptingfilter;

import es.upm.miw.webpattern.http.HttpRequest;
import es.upm.miw.webpattern.http.HttpResponse;
import es.upm.miw.webpattern.http.HttpStatus;
import org.apache.logging.log4j.LogManager;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(HttpRequest request, HttpResponse response, FilterChain filterChain) {
        // PRE-PROCESS
        LogManager.getLogger(this.getClass().getName()).info("Authenticating pre-process...");
        if ("public".equals(request.getPath(0))) {
            filterChain.doFilter(request, response); // si esta autorizado se continua con la cadena de filtros
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED);
            response.setBody("Unsuccessful Authentication Filter");
            // se aborta la cadena de filtros
        }

        // POST-PROCESS
        LogManager.getLogger(this.getClass().getName()).info("Authenticating post-process...");
    }
}
