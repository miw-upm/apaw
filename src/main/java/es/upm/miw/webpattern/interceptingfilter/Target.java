package es.upm.miw.webpattern.interceptingfilter;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.webpattern.http.HttpRequest;
import es.upm.miw.webpattern.http.HttpResponse;

public class Target {
    public void execute(HttpRequest request, HttpResponse response) {
        LogManager.getLogger(this.getClass().getName()).info("---------> Executing TARGET." + request);
    }
}
