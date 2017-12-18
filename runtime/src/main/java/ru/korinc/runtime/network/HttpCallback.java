package ru.korinc.runtime.network;

import java.io.Serializable;

/**
 * Created by gputintsev on 18.12.17.
 */

public class HttpCallback implements Serializable {

    public HttpCallback() {
    }

    public void onResponce(HttpResponse response) {

    }

    public void onFailure(Throwable throwable) {

    }
}
