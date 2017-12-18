package ru.korinc.runtime.rx;


import ru.korinc.runtime.interop.observable.Observable;
import ru.korinc.runtime.interop.subject.BehaviorSubject;

import ru.korinc.runtime.rx.subject.BSWrapper;

/**
 * Created by gputintsev on 15.12.17.
 */

public class JsRxProvider implements RxProvider {

    @Override
    public <T> ObservableWrapper<T> observableCreate(
            ObservableOnSubscribe<T> observableOnSubscribe) {
        Observable<T> res = Observable.create(subscriber -> {
            try {
                observableOnSubscribe.subscribe(new Emitter<T>() {
                    @Override
                    public void onNext(T value) {
                        subscriber.next(value);
                    }

                    @Override
                    public void onError(Throwable error) {
                        subscriber.error(error);
                    }

                    @Override
                    public void onComplete() {
                        subscriber.complete();
                    }
                });
            } catch (Exception e) {
                subscriber.error(e);
            }
            return subscriber;
        });

        return new JsObservable<>(res);
    }

    @Override
    public <T> BSWrapper<T> bs(T defaultValue) {
        return new JsBs<T>(new BehaviorSubject<T>(defaultValue));
    }

    @Override
    public BackgroundSchedulerWrapper scheduler() {
        return new JsBackgroundScheduler();
    }
}
