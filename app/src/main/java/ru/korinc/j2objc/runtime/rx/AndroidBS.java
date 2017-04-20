package ru.korinc.j2objc.runtime.rx;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import ru.korinc.runtime.rx.Consumer;
import ru.korinc.runtime.rx.DisposableWrapper;
import ru.korinc.runtime.rx.subject.BSWrapper;

/**
 * Created by gputintsev on 12.04.17.
 */

public class AndroidBS<T> extends AndroidSubject<T> implements BSWrapper<T> {

    private BehaviorSubject<T> source;

    public AndroidBS(BehaviorSubject<T> source) {
        super(source);
        this.source = source;
    }

    @Override
    public T getValue() {
        return source.getValue();
    }
}
