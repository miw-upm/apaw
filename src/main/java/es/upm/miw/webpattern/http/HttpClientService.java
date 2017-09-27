package es.upm.miw.webpattern.http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpClientService {

    private Server server;

    public HttpClientService(Server server) {
        this.server = server;
    }

    public HttpResponse submit(HttpRequest request) {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.info(request.toString());
        HttpResponse response = server.submit(request);
        logger.info(response);
        logger.info("--------------------ooo------------------------");
        if (response.getStatus().isError()) {
            throw new HttpException(response.getStatus().toString());
        } else {
            return response;
        }
    }
}
