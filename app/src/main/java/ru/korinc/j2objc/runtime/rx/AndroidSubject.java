package ru.korinc.j2objc.runtime.rx;

import io.reactivex.Observable;
import io.reactivex.subjects.Subject;

/**
 * Created by gputintsev on 12.04.17.
 */

abstract class AndroidSubject<T> extends AndroidObservable<T> {

    private Subject<T> source;

    public AndroidSubject(Subject<T> source) {
        super(source);
        this.source = source;
    }

    public void onNext(T o) {
        source.onNext(o);
    }

    public void onError(Throwable e) {
        source.onError(e);
    }

    public void onComplete() {
        source.onComplete();
    }
}
