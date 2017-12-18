package ru.korinc.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.IOException;

import ru.korinc.client.proxy.HttpProxy;
import ru.korinc.runtime.network.HttpCallback;
import ru.korinc.runtime.network.HttpResponse;

/**
 * Created by gputintsev on 18.12.17.
 */

public class HttpProxyImpl extends RemoteServiceServlet implements HttpProxy {

    private Http http = new Http();

    @Override
    public void get(String url, String[] headers, HttpCallback callback)
            throws IllegalArgumentException, IOException {
        http.get(url, headers, callback);
    }

    @Override
    public void put(String url, String[] headers, HttpCallback callback)
            throws IllegalArgumentException, IOException {
        http.get(url, headers, callback);

    }
}
