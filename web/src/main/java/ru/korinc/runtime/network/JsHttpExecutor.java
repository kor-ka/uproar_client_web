package ru.korinc.runtime.network;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import ru.korinc.client.GreetingService;
import ru.korinc.client.GreetingServiceAsync;
import ru.korinc.client.proxy.HttpProxy;
import ru.korinc.client.proxy.HttpProxyAsync;

import static ru.korinc.runtime.RuntimeConfiguration.log;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsHttpExecutor implements HttpExecutor {

    private final HttpProxyAsync proxy = GWT.create(HttpProxy.class);


    @Override
    public void get(String url, String[] headers, HttpCallback callback) throws Exception {
//        log.d("JsHttpExecutor", "get:" + url + " " + headers);
        proxy.get(url, headers, new AsyncCallback<HttpResponse>() {
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(HttpResponse result) {
                callback.onResponce(result);
            }
        });
    }

    @Override
    public void put(String url, String contents, String[] headers, HttpCallback callback)
            throws Exception {
    }
}
