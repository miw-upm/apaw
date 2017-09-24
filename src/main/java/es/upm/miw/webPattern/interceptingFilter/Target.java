package es.upm.miw.webPattern.interceptingFilter;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.webPattern.http.HttpRequest;
import es.upm.miw.webPattern.http.HttpResponse;

public class Target {
	public void execute(HttpRequest request, HttpResponse response) {
	    LogManager.getLogger(this.getClass().getName()).info("---------> Executing TARGET...");
	}
}
