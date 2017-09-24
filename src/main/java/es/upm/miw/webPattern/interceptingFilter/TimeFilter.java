package es.upm.miw.webPattern.interceptingFilter;

import java.util.Date;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.webPattern.http.HttpRequest;
import es.upm.miw.webPattern.http.HttpResponse;

public class TimeFilter extends Filter {

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
