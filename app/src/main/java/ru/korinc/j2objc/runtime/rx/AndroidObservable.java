package ru.korinc.j2objc.runtime.rx;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import ru.korinc.runtime.rx.Consumer;
import ru.korinc.runtime.rx.DisposableWrapper;
import ru.korinc.runtime.rx.ObservableWrapper;
import ru.korinc.runtime.rx.BackgroundSchedulerWrapper;

/**
 * Created by gputintsev on 12.04.17.
 */

public class AndroidObservable<T> implements ObservableWrapper<T> {

    private Observable<T> source;

    public AndroidObservable(Observable<T> source) {
        this.source = source;
    }


    public ObservableWrapper<T> observeOnMain() {
        return new AndroidObservable<>(source.observeOn(AndroidSchedulers.mainThread()));
    }

    public ObservableWrapper<T> observeOn(BackgroundSchedulerWrapper scheduler) {
        return new AndroidObservable<>(
                source.observeOn(((AndroidBackgroundScheduler) scheduler).getScheduler()));
    }

    public ObservableWrapper<T> subscribeOn(BackgroundSchedulerWrapper scheduler) {
        return new AndroidObservable<>(
                source.subscribeOn(((AndroidBackgroundScheduler) scheduler).getScheduler()));
    }

    public DisposableWrapper subscribe(final Consumer<T> consumer) {
        Disposable d = source.subscribe(new io.reactivex.functions.Consumer<T>() {
            @Override
            public void accept(@NonNull T t) throws Exception {
                consumer.accept(t);
            }
        });
        return new AndroidDisposable(d);
    }

    public <R> ObservableWrapper<R> map(
            final ru.korinc.runtime.rx.Function<? super T, ? extends R> func1) {
        return new AndroidObservable<>(source.map(new Function<T, R>() {
            @Override
            public R apply(@NonNull T t) throws Exception {
                return func1.apply(t);
            }
        }));
    }

    public <R> ObservableWrapper<R> flatMap(
            final ru.korinc.runtime.rx.Function<? super T, ? extends ObservableWrapper<? extends R>> mapper) {
        Observable<R> res = source.flatMap(new Function<T, ObservableSource<R>>() {
            @Override
            public ObservableSource<R> apply(@NonNull T t) throws Exception {
                return ((AndroidObservable<R>) mapper.apply(t)).source;
            }
        });

        return new AndroidObservable<>(res);
    }

    public Observable<T> getSource() {
        return source;
    }

    public ObservableWrapper<T> throttleLast(long windowMillis) {
        return new AndroidObservable<T>(
                source.throttleWithTimeout(windowMillis, TimeUnit.MILLISECONDS));
    }

    @Override
    public ObservableWrapper<T> delay(long millis) {
        return new AndroidObservable<T>(source.delay(millis, TimeUnit.MILLISECONDS));

    }

    @Override
    public ObservableWrapper<Long> timer(long millis) {
        return new AndroidObservable<>(Observable.timer(millis, TimeUnit.MILLISECONDS));
    }

    @Override
    public ObservableWrapper<T> retryWhen(
            ru.korinc.runtime.rx.Function<? super ObservableWrapper<Throwable>, ? extends ObservableWrapper<?>> handler) {
        return new AndroidObservable<>(source.retryWhen(
                throwableObservable -> ((AndroidObservable<?>) handler
                        .apply(new AndroidObservable<>(throwableObservable))).source));

    }

    @Override
    public <S> ObservableWrapper<S> switchOnNext(
            ObservableWrapper<? extends ObservableWrapper<? extends S>> sources) {
        Observable<ObservableSource<S>> converted
                = ((AndroidObservable<ObservableWrapper<S>>) sources).source
                .map(tObservableWrapper -> ((AndroidObservable<S>) tObservableWrapper).source);
        Observable<S> res = Observable.switchOnNext(converted);
        return new AndroidObservable<S>(res);
    }


}
