package ru.korinc.j2objc.runtime.network;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import ru.korinc.runtime.network.HttpResponse;
import ru.korinc.runtime.network.HttpExecutor;

import static ru.korinc.core.utils.Utils.apply;


/**
 * Created by gputintsev on 20.03.17.
 */

public class Http implements HttpExecutor {


    @Override
    public HttpResponse get(String url, String... headers) throws IOException {

        final Request.Builder builder = new Request.Builder().url(url);
        for (int i = 0; i < headers.length; i++) {
            if (i % 2 == 0) {
                builder.addHeader(headers[i], headers[i + 1]);
            }
        }
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(builder.build()).execute();
        return new HttpResponse(response.code(), response.body().string(), url);
    }

    @Override
    public HttpResponse put(String url, String contents, String... headers)
            throws IOException {
        final Request.Builder builder = new Request.Builder().url(url)
                .method("PUT", RequestBody.create(null, contents));
        for (int i = 0; i < headers.length; i++) {
            if (i % 2 == 0) {
                builder.addHeader(headers[i], headers[i + 1]);
            }
        }
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(builder.build()).execute();
        return new HttpResponse(response.code(), response.body().string(), url);
    }
}
