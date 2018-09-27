package es.upm.miw.webpattern.http;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest extends HttpBase {

    private String path;

    private HttpMethod method;

    private Map<String, String> queryParams;

    public HttpRequest(String path) {
        this.path = path;
        this.method = HttpMethod.GET;
        queryParams = new HashMap<>();
    }

    public static Builder builder(String path) {
        return new Builder(path);
    }

    public String getPath(int order) {
        return this.path.split("/")[order + 1];
    }

    public boolean isEqualsPath(String pathTemplate) {
        String[] pathTemplateArray = pathTemplate.split("/");
        String[] pathArray = this.path.split("/");
        if (pathArray.length != pathTemplateArray.length) {
            return false;
        } else {
            for (int i = 0; i < pathArray.length; i++) {
                if (pathTemplateArray[i].indexOf('{') == -1 && !pathTemplateArray[i].equals(pathArray[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getPath() {
        return path;
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

    @Override
    public String toString() {
        return this.method.toString() + ' ' + this.path + this.queryParams() + "   " + super.toString();
    }

    public static class Builder {
        private HttpRequest httpRequest;

        private Builder(String path) {
            this.httpRequest = new HttpRequest(path);
        }

        public Builder path(String path) {
            this.httpRequest.path = httpRequest.getPath() + path;
            return this;
        }

        public Builder expandPath(String value) {
            httpRequest.path = httpRequest.path.substring(0, httpRequest.path.indexOf('{'))
                    + value
                    + httpRequest.path.substring(httpRequest.path.indexOf('}') + 1);
            return this;
        }

        public Builder param(String key, String value) {
            httpRequest.addQueryParam(key, value);
            return this;
        }

        public Builder headerParam(String key, String value) {
            httpRequest.addHeaderParam(key, value);
            return this;
        }

        public Builder body(Object body) {
            httpRequest.setBody(body);
            return this;
        }

        public HttpRequest post() {
            httpRequest.method = HttpMethod.POST;
            return this.httpRequest;
        }

        public HttpRequest get() {
            httpRequest.method = HttpMethod.GET;
            return httpRequest;
        }

        public HttpRequest put() {
            httpRequest.method = HttpMethod.PUT;
            return httpRequest;
        }

        public HttpRequest patch() {
            httpRequest.method = HttpMethod.PATCH;
            return httpRequest;
        }

        public HttpRequest delete() {
            httpRequest.method = HttpMethod.DELETE;
            return httpRequest;
        }

    }

}
