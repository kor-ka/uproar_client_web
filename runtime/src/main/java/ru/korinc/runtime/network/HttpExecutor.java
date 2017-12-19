package ru.korinc.runtime.network;

import com.google.j2objc.annotations.ObjectiveCName;

/**
 * Created by gputintsev on 20.03.17.
 */

public interface HttpExecutor {

    @ObjectiveCName("getMethodWithUrl:WithHeaders:WithCallback:")
    void get(String url, String[] headers, HttpCallback callback) throws Exception;

    @ObjectiveCName("putMethodWithUrl:WithContent:WithHeaders:WithCallback:")
    void put(String url, String contents, String[] headers, HttpCallback callback)
            throws Exception;
}
