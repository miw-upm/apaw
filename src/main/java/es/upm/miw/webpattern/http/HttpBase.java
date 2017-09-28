package es.upm.miw.webpattern.http;

import java.util.HashMap;
import java.util.Map;

public class HttpBase {

    private Map<String, String> headerParams;

    private Map<String, String> cookies;

    private String body;

    public HttpBase() {
        cookies = new HashMap<>();
        headerParams = new HashMap<>();
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void addCookie(String key, String value) {
        cookies.put(key, value);
    }

    public Map<String, String> getHeaderParams() {
        return headerParams;
    }

    public void addHeaderParam(String key, String value) {
        headerParams.put(key, value);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!headerParams.isEmpty()) {
            stringBuilder.append("  headerParams=" + headerParams);
        }
        if (!cookies.isEmpty()) {
            stringBuilder.append(", cookies=" + cookies);
        }
        if (body != null) {
            stringBuilder.append(", body=" + body);
        }
        return stringBuilder.toString();
    }

}
