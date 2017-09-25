package es.upm.miw.webpattern.interceptingfilter;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.webpattern.http.HttpRequest;
import es.upm.miw.webpattern.http.HttpResponse;

public class DebugFilter extends Filter {

    @Override
    public void doFilter(HttpRequest request, HttpResponse response, FilterChain filterChain) {
    	//PRE-PROCESS
        LogManager.getLogger(this.getClass().getName()).info("Debuging pre-process...");
        filterChain.doFilter(request, response);
        
    	//POST-PROCESS
        response.getHeaderParams().put("debug", "DebugFilter");
        LogManager.getLogger(this.getClass().getName()).info("Debuging post-process...");
    }
}
