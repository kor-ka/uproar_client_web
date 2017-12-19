package ru.korinc.runtime.network;



import ru.korinc.runtime.rx.ObservableOnSubscribe;
import ru.korinc.runtime.rx.ObservableWrapper;

import static ru.korinc.runtime.RuntimeConfiguration.http;
import static ru.korinc.runtime.RuntimeConfiguration.log;
import static ru.korinc.runtime.RuntimeConfiguration.rxProvider;


/**
 * Created by gputintsev on 20.03.17.
 */

public class HttpObserver {

    public static ObservableWrapper<HttpResponse> get(String url, String... headers) {
        return rxProvider.observableCreate((ObservableOnSubscribe<HttpResponse>) e -> {
            try {
                log.d("HttpObserver", "try get: " + url + " " + headers);

                http.getExecutor().get(url, headers, new HttpCallback() {
                    @Override
                    public void onResponce(HttpResponse response) {
                        if (response.getCode() / 100 == 2) {
                            log.d("HttpObserver", "res get: " + url + " " + response.getContent());

                            e.onNext(response);
                            e.onComplete();
                        } else {
                            Exception error = new Exception(
                                    "URL: " + url + "\nHttp error code" + response.getCode());
                            e.onError(error);
                            log.e(error);
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        log.e(throwable);

                        e.onError(throwable);
                    }
                });

            } catch (Exception ex) {
                log.e(ex);
                e.onError(ex);
            }
        }).retryWhen(throwableObservableWrapper -> throwableObservableWrapper
                .flatMap(t -> throwableObservableWrapper.timer(500)));
    }

    public static ObservableWrapper<HttpResponse> put(String url, String data, String... headers) {

        return rxProvider.observableCreate((ObservableOnSubscribe<HttpResponse>) e -> {
            try {
                http.getExecutor().put(url, data, headers, new HttpCallback() {
                    @Override
                    public void onResponce(HttpResponse response) {
                        if (response.getCode() / 100 == 2) {
                            e.onNext(response);
                            e.onComplete();
                        } else {
                            e.onError(new Exception(
                                    "URL: " + url + "\nHttp error code" + response.getCode()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        e.onError(throwable);
                    }
                });


            } catch (Exception ex) {
                log.e(ex);
                e.onError(ex);
            }
        }).retryWhen(throwableObservableWrapper -> throwableObservableWrapper.delay(5000));
    }
}
