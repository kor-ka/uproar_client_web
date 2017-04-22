package ru.korinc.runtime.rx.casthell;

import ru.korinc.runtime.rx.BackgroundSchedulerWrapper;
import ru.korinc.runtime.rx.Consumer;
import ru.korinc.runtime.rx.DisposableWrapper;
import ru.korinc.runtime.rx.Function;
import ru.korinc.runtime.rx.ObservableWrapper;

/**
 * Created by gputintsev on 17.04.17.
 */

public abstract class TypedObservable<T> implements ObservableWrapper<T> {

    private ObservableWrapper<T> source;

    public TypedObservable(ObservableWrapper<T> source) {
        this.source = source;
    }

    protected abstract TypedObservable<T> fromInternal(ObservableWrapper<T> source);


    @Override
    public ObservableWrapper<T> observeOnMain() {
        return fromInternal(source.observeOnMain());
    }

    @Override
    public ObservableWrapper<T> observeOn(BackgroundSchedulerWrapper scheduler) {
        return fromInternal(source.observeOn(scheduler));
    }

    @Override
    public ObservableWrapper<T> subscribeOn(BackgroundSchedulerWrapper scheduler) {
        return fromInternal(source.subscribeOn(scheduler));
    }

    @Override
    public DisposableWrapper subscribe(Consumer<T> consumer) {
        return source.subscribe(consumer);
    }

    @Override
    public <R> ObservableWrapper<R> map(Function<? super T, ? extends R> func1) {
        return null;
    }

    @Override
    public <R> ObservableWrapper<R> flatMap(
            Function<? super T, ? extends ObservableWrapper<? extends R>> mapper) {
        return null;
    }

    @Override
    public ObservableWrapper<T> throttleFirst(long windowMillis) {
        return fromInternal(source.throttleFirst(windowMillis));
    }

    @Override
    public ObservableWrapper<T> delay(long millis) {
        return fromInternal(source.delay(millis));
    }

    @Override
    public ObservableWrapper<T> retryWhen(
            Function<? super ObservableWrapper<Throwable>, ? extends ObservableWrapper<?>> handler) {
        return fromInternal(source.retryWhen(handler));
    }

    public ObservableWrapper<T> getSource() {
        return source;
    }
}
