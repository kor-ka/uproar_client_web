package ru.korinc.client.proxy;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.io.IOException;

import ru.korinc.runtime.network.HttpCallback;
import ru.korinc.runtime.network.HttpResponse;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("proxy")
public interface HttpProxy extends RemoteService {

    void get(String url, String[] headers, HttpCallback callback)
            throws IllegalArgumentException, IOException;

    void put(String url, String[] headers, HttpCallback callback)
            throws IllegalArgumentException, IOException;
}
