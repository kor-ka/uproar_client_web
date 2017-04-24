package ru.korinc.j2objc.runtime.network.mok;

import java.util.Map;

import ru.korinc.j2objc.runtime.network.Http;
import ru.korinc.runtime.network.HttpResponse;
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
    public HttpResponse get(String url, String... headers) throws Exception {
        return mHttp.get(url, headers);
    }

    @Override
    public HttpResponse put(String url, String contents, String... headers)
            throws Exception {
        return null;
    }
}
