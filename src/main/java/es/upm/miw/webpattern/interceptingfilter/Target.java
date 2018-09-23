package es.upm.miw.webpattern.interceptingfilter;

import es.upm.miw.webpattern.http.HttpRequest;
import es.upm.miw.webpattern.http.HttpResponse;
import org.apache.logging.log4j.LogManager;

public class Target {
    public void execute(HttpRequest request, HttpResponse response) {
        LogManager.getLogger(this.getClass().getName()).info("---------> Executing TARGET." + request);
    }
}
