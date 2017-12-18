package ru.korinc.server.proxy;

import java.io.IOException;

import ru.korinc.client.proxy.HttpProxy;
import ru.korinc.runtime.network.HttpResponse;

/**
 * Created by gputintsev on 18.12.17.
 */

public class HttpProxyImpl implements HttpProxy {

    private Http http = new Http();

    @Override
    public HttpResponse get(String url, String... headers)
            throws IllegalArgumentException, IOException {
        return http.get(url, headers);
    }

    @Override
    public HttpResponse put(String url, String... headers)
            throws IllegalArgumentException, IOException {
        return http.get(url, headers);

    }
}
