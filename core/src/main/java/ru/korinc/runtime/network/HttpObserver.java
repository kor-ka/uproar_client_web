package ru.korinc.runtime.network;


import java.util.HashMap;

import ru.korinc.runtime.rx.ObservableOnSubscribe;
import ru.korinc.runtime.rx.ObservableWrapper;

import static ru.korinc.runtime.RuntimeConfiguration.http;
import static ru.korinc.runtime.RuntimeConfiguration.log;
import static ru.korinc.runtime.RuntimeConfiguration.rxProvider;


/**
 * Created by gputintsev on 20.03.17.
 */

public class HttpObserver {

    public static ObservableWrapper<HTTPResponse> get(String url, HashMap<String, String> headers) {

        return rxProvider.observableCreate((ObservableOnSubscribe<HTTPResponse>) e -> {
            try {
                HTTPResponse response = http.getExecutor().getMethod(url, headers);
                if (response.getCode() / 100 == 2) {
                    e.onNext(response);
                    e.onComplete();
                } else {
                    e.onError(new Exception(
                            "URL: " + url + "\nHttp error code" + response.getCode()));
                }
            } catch (Exception ex) {
                log.e(ex);
                e.onError(ex);
            }
        }).retryWhen(throwableObservableWrapper -> throwableObservableWrapper.delay(5000));
    }

    public static ObservableWrapper<HTTPResponse> put(String url, byte[] data,
            HashMap<String, String> headers) {

        return rxProvider.observableCreate((ObservableOnSubscribe<HTTPResponse>) e -> {
            try {
                HTTPResponse response = http.getExecutor().putMethod(url, data, headers);
                if (response.getCode() / 100 == 2) {
                    e.onNext(response);
                    e.onComplete();
                } else {
                    e.onError(new Exception(
                            "URL: " + url + "\nHttp error code" + response.getCode()));
                }
            } catch (Exception ex) {
                log.e(ex);
                e.onError(ex);
            }
        }).retryWhen(throwableObservableWrapper -> throwableObservableWrapper.delay(5000));
    }
}
