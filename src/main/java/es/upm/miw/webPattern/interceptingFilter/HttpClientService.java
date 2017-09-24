package es.upm.miw.webPattern.interceptingFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.webPattern.http.HttpException;
import es.upm.miw.webPattern.http.HttpRequest;
import es.upm.miw.webPattern.http.HttpResponse;

public class HttpClientService {

    public HttpResponse submit(HttpRequest request) {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.info(request.toString());
        HttpResponse response = new Server().submit(request);
        logger.info(response);
        logger.info("---------------------------------------ooo----------------------------------------");
        if (response.getStatus().isError()) {
            throw new HttpException(response.getStatus().toString());
        }
        return response;
    }
}
