package es.upm.miw.webpattern.interceptingfilter;

import es.upm.miw.webpattern.http.HttpRequest;
import es.upm.miw.webpattern.http.HttpResponse;
import org.apache.logging.log4j.LogManager;

import java.util.Date;

public class TimeFilter implements Filter {

    @Override
    public void doFilter(HttpRequest request, HttpResponse response, FilterChain filterChain) {
        // PRE-PROCESS
        long requestTime = new Date().getTime();
        LogManager.getLogger(this.getClass().getName()).info("Time pre-process: " + new Date());

        filterChain.doFilter(request, response);

        // POST-PROCESS
        String time = (new Date().getTime() - requestTime) + "ms";
        LogManager.getLogger(this.getClass().getName()).info("Time post-process: " + time);
        response.getHeaderParams().put("time", time);
    }
}
