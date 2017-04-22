package ru.korinc.runtime.rx.casthell;

import ru.korinc.runtime.rx.ObservableWrapper;

/**
 * Created by gputintsev on 17.04.17.
 */

public class StringObservable extends TypedObservable<String> {

    public StringObservable(ObservableWrapper<String> source) {
        super(source);
    }

    @Override
    protected TypedObservable fromInternal(ObservableWrapper<String> source) {
        return new StringObservable(source);
    }

    public static StringObservable from(ObservableWrapper<String> source) {
        return new StringObservable(source);
    }

}
