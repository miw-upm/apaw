package es.upm.miw.webpattern.http;

import java.util.HashMap;
import java.util.Map;

public class HttpBase {

    private Map<String, String> headerParams;

    private Object body;

    public HttpBase() {
        headerParams = new HashMap<>();
    }

    public Map<String, String> getHeaderParams() {
        return headerParams;
    }

    public void addHeaderParam(String key, String value) {
        headerParams.put(key, value);
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!headerParams.isEmpty()) {
            stringBuilder.append("  headerParams=" + headerParams);
        }
        if (body != null) {
            stringBuilder.append(", body=" + body);
        }
        return stringBuilder.toString();
    }

}
