package ru.korinc.client.proxy;


/**
 * The client-side stub for the RPC service.
 */
public interface HttpProxyAsync {

    void get(java.lang.String url, java.lang.String[] headers,
            com.google.gwt.user.client.rpc.AsyncCallback<ru.korinc.runtime.network.HttpResponse> arg3);

    void put(java.lang.String url, java.lang.String[] headers,
            com.google.gwt.user.client.rpc.AsyncCallback<ru.korinc.runtime.network.HttpResponse> arg3);
}