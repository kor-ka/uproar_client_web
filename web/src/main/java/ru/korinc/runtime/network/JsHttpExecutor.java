package ru.korinc.runtime.network;

import com.google.gwt.core.client.GWT;

import ru.korinc.client.GreetingService;
import ru.korinc.client.GreetingServiceAsync;
import ru.korinc.client.proxy.HttpProxy;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsHttpExecutor implements HttpExecutor {

    private final HttpProxy proxy = GWT.create(HttpProxy.class);


    @Override
    public HttpResponse get(String url, String... headers) throws Exception {
        return proxy.get(url, headers);
    }

    @Override
    public HttpResponse put(String url, String contents, String... headers) throws Exception {
        return proxy.put(url, headers);

    }
}
