package ru.korinc.runtime.network;

import java.util.HashMap;

/**
 * Created by gputintsev on 20.03.17.
 */

public interface HttpExecutor {

    HTTPResponse getMethod(String url, HashMap<String, String> headers) throws Exception;

    HTTPResponse putMethod(String url, byte[] contents, HashMap<String, String> headers)
            throws Exception;

}
