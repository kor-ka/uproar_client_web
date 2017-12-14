package ru.korinc.runtime.network;

public class HttpResponse {

    private final int code;

    private final String content;

    private String url = "";

    private String[] headers;

    public HttpResponse(int code, String content, String url, String... headers) {
        this.code = code;
        this.content = content;
        this.url = url;
        this.headers = headers;
    }

    public HttpResponse(int code, String content, String url) {
        this.url = url;
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public boolean filter() {
        return code != 0;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public String[] getHeaders() {
        return headers;
    }
}
