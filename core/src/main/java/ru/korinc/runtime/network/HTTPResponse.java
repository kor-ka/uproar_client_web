package ru.korinc.runtime.network;


import java.util.HashMap;

public class HTTPResponse {

    private final int code;

    private final byte[] content;

    private String url = "";

    private HashMap<String, String> headers = new HashMap<>();

    public HTTPResponse(int code, byte[] content, String url, HashMap<String, String> headers) {
        this.code = code;
        this.content = content;
        this.url = url;
        this.headers = headers;
    }

    public HTTPResponse(int code, byte[] content, String url) {
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

    public byte[] getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }
}
