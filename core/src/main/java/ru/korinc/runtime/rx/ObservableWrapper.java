package ru.korinc.runtime.rx;

import com.google.j2objc.annotations.ObjectiveCName;

/**
 * Created by gputintsev on 12.04.17.
 */

public interface ObservableWrapper<T> {

    @ObjectiveCName("observeOnMain")
    ObservableWrapper<T> observeOnMain();

    @ObjectiveCName("observeOnWithScheduler:")
    ObservableWrapper<T> observeOn(BackgroundSchedulerWrapper scheduler);

    @ObjectiveCName("subscribeOnWithScheduler:")
    ObservableWrapper<T> subscribeOn(BackgroundSchedulerWrapper scheduler);

    @ObjectiveCName("subscribeWithConsumer:")
    DisposableWrapper subscribe(Consumer<T> consumer);

    @ObjectiveCName("mapWithFunc:")
    <R> ObservableWrapper<R> map(Function<? super T, ? extends R> func1);

    @ObjectiveCName("flatMapWithFunc:")
    <R> ObservableWrapper<R> flatMap(
            Function<? super T, ? extends ObservableWrapper<? extends R>> mapper);

    @ObjectiveCName("throttleFirstWithWindowMillis:")
    ObservableWrapper<T> throttleFirst(long windowMillis);

    @ObjectiveCName("delayWithWindowMillis:")
    ObservableWrapper<T> delay(long millis);

    @ObjectiveCName("retryWhenWithWindowMillis:")
    ObservableWrapper<T> retryWhen(
            Function<? super ObservableWrapper<Throwable>, ? extends ObservableWrapper<?>> handler);

}