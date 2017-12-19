package ru.korinc.runtime.rx;

import ru.korinc.runtime.interop.observable.Observable;
import ru.korinc.runtime.interop.scheduler.Scheduler;

/**
 * Created by gputintsev on 15.12.17.
 */

public class JsObservable<T> implements ObservableWrapper<T> {

    private Observable<T> source;

    public JsObservable(Observable<T> source) {
        this.source = source;
    }

    @Override
    public ObservableWrapper<T> observeOnMain() {
        return new JsObservable<>(source.observeOn(Scheduler.animationFrame));
    }

    @Override
    public ObservableWrapper<T> observeOn(BackgroundSchedulerWrapper scheduler) {
        return new JsObservable<>(
                source.observeOn(((JsBackgroundScheduler) scheduler).getScheduler()));
    }

    @Override
    public ObservableWrapper<T> subscribeOn(BackgroundSchedulerWrapper scheduler) {
        return new JsObservable<>(
                source.subscribeOn(((JsBackgroundScheduler) scheduler).getScheduler()));

    }

    @Override
    public DisposableWrapper subscribe(Consumer<T> consumer) {
        return new JsDisposable(source.subscribe(t -> {
            try {
                consumer.accept(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }));
    }

    @Override
    public <R> ObservableWrapper<R> map(Function<? super T, ? extends R> func1) {
        Observable<R> res = source.map(t -> {
            try {
                return func1.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return new JsObservable<>(res);
    }

    @Override
    public <R> ObservableWrapper<R> flatMap(
            Function<? super T, ? extends ObservableWrapper<? extends R>> mapper) {
        return new JsObservable<>(source.flatMap((item, index) -> {
            try {
                return ((JsObservable<R>) mapper.apply(item)).source;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }));
    }

    @Override
    public ObservableWrapper<T> throttleLast(long windowMillis) {
        return new JsObservable<>(source.debounceTime((int) windowMillis));
    }

    @Override
    public ObservableWrapper<T> delay(long millis) {
        return new JsObservable<>(source.delay((int) millis));
    }

    @Override
    public ObservableWrapper<Long> timer(long millis) {
        return new JsObservable<Long>(Observable.timer((int) millis).mapTo(millis));
    }

    @Override
    public ObservableWrapper<T> retryWhen(
            Function<? super ObservableWrapper<Throwable>, ? extends ObservableWrapper<?>> handler) {
        return new JsObservable<>(source.retryWhen(throwableObservable -> ((JsObservable<?>) handler
                .apply(new JsObservable<Throwable>(throwableObservable))).source));

    }

    @Override
    public <S> ObservableWrapper<S> switchOnNext(
            ObservableWrapper<? extends ObservableWrapper<? extends S>> sources) {
        Observable<Observable<S>> converted = ((JsObservable<ObservableWrapper<S>>) sources).source
                .map(tObservableWrapper -> ((JsObservable<S>) tObservableWrapper).source);
        return new JsObservable<S>((Observable<S>) converted._switch());
    }
}
