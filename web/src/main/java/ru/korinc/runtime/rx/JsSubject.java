package ru.korinc.runtime.rx;

import ru.korinc.runtime.interop.subject.Subject;

import ru.korinc.runtime.rx.subject.SubjectWrapper;

/**
 * Created by gputintsev on 18.12.17.
 */

public abstract class JsSubject<T> extends JsObservable<T> implements SubjectWrapper<T> {

    private Subject<T> source;

    public JsSubject(Subject<T> source) {
        super(source);
        this.source = source;
    }

    @Override
    public void onNext(T t) {
        source.next(t);
    }

    @Override
    public void onError(Throwable e) {
        source.error(e);
    }

    @Override
    public void onComplete() {
        source.complete();
    }
}
