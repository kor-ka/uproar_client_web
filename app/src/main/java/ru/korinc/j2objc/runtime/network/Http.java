package ru.korinc.j2objc.runtime.network;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;

import ru.korinc.runtime.network.HTTPResponse;
import ru.korinc.runtime.network.HttpExecutor;

import static ru.korinc.utils.Utils.apply;


/**
 * Created by gputintsev on 20.03.17.
 */

public class Http implements HttpExecutor {


    @Override
    public HTTPResponse getMethod(String url, HashMap<String, String> headers) throws IOException {

        final Request.Builder builder = new Request.Builder().url(url);
        apply(headers.entrySet(), (iterator, e) -> builder.addHeader(e.getKey(), e.getValue()));
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(builder.build()).execute();
        return new HTTPResponse(response.code(), response.body().bytes(), url);
    }

    @Override
    public HTTPResponse putMethod(String url, byte[] contents, HashMap<String, String> headers)
            throws IOException {
        final Request.Builder builder = new Request.Builder().url(url)
                .method("PUT", RequestBody.create(null, contents));
        apply(headers.entrySet(), (iterator, e) -> builder.addHeader(e.getKey(), e.getValue()));
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(builder.build()).execute();
        return new HTTPResponse(response.code(), response.body().bytes(), url);
    }
}
