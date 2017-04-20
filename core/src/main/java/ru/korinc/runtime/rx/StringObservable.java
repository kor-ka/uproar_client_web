package ru.korinc.runtime.rx;

import ru.korinc.runtime.rx.Consumer;
import ru.korinc.runtime.rx.DisposableWrapper;
import ru.korinc.runtime.rx.ObservableWrapper;

/**
 * Created by gputintsev on 17.04.17.
 */

public class StringObservable implements ObservableWrapper<String> {

    private ObservableWrapper<String> source;

    public StringObservable(ObservableWrapper<String> source) {
        this.source = source;
    }

    public static StringObservable from(ObservableWrapper<String> source) {
        return new StringObservable(source);
    }


    @Override
    public StringObservable observeOnMain() {
        return StringObservable.from(source.observeOnMain());
    }

    @Override
    public ObservableWrapper<String> observeOn(BackgroundSchedulerWrapper scheduler) {
        return StringObservable.from(source.observeOn(scheduler));
    }

    @Override
    public ObservableWrapper<String> subscribeOn(BackgroundSchedulerWrapper scheduler) {
        return StringObservable.from(source.subscribeOn(scheduler));
    }

    @Override
    public DisposableWrapper subscribe(Consumer<String> consumer) {
        return source.subscribe(consumer);
    }

    @Override
    public <R> ObservableWrapper<R> map(Function<? super String, ? extends R> func1) {
        return null;
    }

    @Override
    public <R> ObservableWrapper<R> flatMap(
            Function<? super String, ? extends ObservableWrapper<? extends R>> mapper) {
        return null;
    }

    public ObservableWrapper<String> getSource() {
        return source;
    }
}
