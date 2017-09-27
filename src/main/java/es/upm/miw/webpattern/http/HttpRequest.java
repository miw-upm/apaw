package es.upm.miw.webpattern.http;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest extends HttpBase {

	private String path;

	private HttpMethod method;

	private Map<String, String> queryParams;

	public HttpRequest(String path, HttpMethod method) {
		this.path = path;
		this.method = method;
		queryParams = new HashMap<>();
	}

	public HttpRequest() {
		this("", HttpMethod.GET);
	}

	public String getPath() {
		return path;
	}

	public String[] paths() {
		return path.split("/");
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public Map<String, String> getParams() {
		return queryParams;
	}

	public void addQueryParam(String key, String value) {
		queryParams.put(key, value);
	}

	public void clearQueryParams() {
		queryParams.clear();
	}

	@Override
	public String toString() {
		return method.toString() + " /" + path + this.queryParams() + "   " + super.toString();
	}

    private String queryParams() {
        StringBuilder query = new StringBuilder();
        String separator = "?";
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            query.append(separator);
            query.append(entry.getKey());
            query.append("=");
            query.append(entry.getValue());
            separator = "&";
        }
        return query.toString();
    }

}
