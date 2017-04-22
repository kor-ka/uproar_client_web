package ru.korinc.j2objc.runtime.network.mok;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import ru.korinc.j2objc.runtime.network.Http;
import ru.korinc.runtime.network.HTTPResponse;
import ru.korinc.runtime.network.HttpExecutor;


/**
 * Created by gputintsev on 21.03.17.
 */

public class HttpMock implements HttpExecutor {


    Http mHttp;

    public HttpMock(Http http) {
        mHttp = http;
    }


    private void assertTrue(boolean toAssert) throws Exception {
        if (toAssert) {
            throw new Exception("assert");
        }
    }

    private void assertFalse(boolean toAssert) throws Exception {
        if (!toAssert) {
            throw new Exception("assert");
        }
    }

    @Override
    public HTTPResponse getMethod(String url, HashMap<String, String> headers) throws Exception {
        return mHttp.getMethod(url, headers);
    }

    @Override
    public HTTPResponse putMethod(String url, byte[] contents, HashMap<String, String> headers)
            throws Exception {
        return null;
    }
}
