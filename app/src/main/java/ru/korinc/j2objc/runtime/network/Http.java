package ru.korinc.j2objc.runtime.network;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import ru.korinc.runtime.network.HttpCallback;
import ru.korinc.runtime.network.HttpResponse;
import ru.korinc.runtime.network.HttpExecutor;

import static ru.korinc.core.utils.Utils.apply;


/**
 * Created by gputintsev on 20.03.17.
 */

public class Http implements HttpExecutor {


    @Override
    public void get(String url, String[] headers, HttpCallback callback) throws IOException {

        final Request.Builder builder = new Request.Builder().url(url);
        for (int i = 0; i < headers.length; i++) {
            if (i % 2 == 0) {
                builder.addHeader(headers[i], headers[i + 1]);
            }
        }
        OkHttpClient client = new OkHttpClient();

        try {
            Response response = client.newCall(builder.build()).execute();
            callback.onResponce(new HttpResponse(response.code(), response.body().string(), url));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    @Override
    public void put(String url, String contents, String[] headers, HttpCallback callback)
            throws IOException {
        final Request.Builder builder = new Request.Builder().url(url)
                .method("PUT", RequestBody.create(null, contents));
        for (int i = 0; i < headers.length; i++) {
            if (i % 2 == 0) {
                builder.addHeader(headers[i], headers[i + 1]);
            }
        }
        OkHttpClient client = new OkHttpClient();

        try {
            Response response = client.newCall(builder.build()).execute();
            callback.onResponce(new HttpResponse(response.code(), response.body().string(), url));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }
}
