package ru.korinc.j2objc.runtime.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.subjects.BehaviorSubject;
import ru.korinc.runtime.rx.BackgroundSchedulerWrapper;
import ru.korinc.runtime.rx.Emitter;
import ru.korinc.runtime.rx.ObservableOnSubscribe;
import ru.korinc.runtime.rx.ObservableWrapper;
import ru.korinc.runtime.rx.RxProvider;
import ru.korinc.runtime.rx.subject.BSWrapper;

/**
 * Created by gputintsev on 12.04.17.
 */

public class AndroidRxProvider implements RxProvider {

    @Override
    public <T> ObservableWrapper<T> observableCreate(
            final ObservableOnSubscribe<T> observableOnSubscribe) {
        Observable<T> res = Observable.create(new io.reactivex.ObservableOnSubscribe<T>() {

            @Override
            public void subscribe(final ObservableEmitter<T> e) throws Exception {
                observableOnSubscribe.subscribe(new Emitter<T>() {
                    @Override
                    public void onNext(T value) {
                        e.onNext(value);
                    }

                    @Override
                    public void onError(Throwable error) {
                        e.onError(error);

                    }

                    @Override
                    public void onComplete() {
                        e.onComplete();
                    }
                });
            }
        });

        return new AndroidObservable<>(res);
    }

    @Override
    public <T> BSWrapper<T> bs(T defaultValue) {
        BehaviorSubject<T> res = BehaviorSubject.createDefault(defaultValue);
        return new AndroidBS<>(res);
    }

    @Override
    public BackgroundSchedulerWrapper scheduler() {
        return new AndroidBackgroundScheduler();
    }
}
