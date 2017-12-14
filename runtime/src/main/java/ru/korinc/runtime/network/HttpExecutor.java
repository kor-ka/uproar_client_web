package ru.korinc.runtime.network;

import com.google.j2objc.annotations.ObjectiveCName;

import java.util.Map;

/**
 * Created by gputintsev on 20.03.17.
 */

public interface HttpExecutor {

    @ObjectiveCName("getMethodWithUrl:WithHeaders:")
    HttpResponse get(String url, String... headers) throws Exception;

    @ObjectiveCName("putMethodWithUrl:WithContent:WithHeaders:")
    HttpResponse put(String url, String contents, String... headers)
            throws Exception;
}
