package es.upm.miw.webPattern.frontControllerApi;

import es.upm.miw.webPattern.http.HttpRequest;
import es.upm.miw.webPattern.http.HttpResponse;

public class Server {
	private Dispatcher dispatcher = new Dispatcher();

	public HttpResponse submit(HttpRequest request) {
		HttpResponse response = new HttpResponse();
		switch (request.getMethod()) {
		case POST:
			dispatcher.doPost(request, response);
			break;
		case GET:
			dispatcher.doGet(request, response);
			break;
		case PUT:
			dispatcher.doPut(request, response);
			break;
		case DELETE:
			dispatcher.doDelete(request, response);
			break;
		default:
		}
		return response;
	}

}