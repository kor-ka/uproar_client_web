package ru.korinc.runtime.rx;

public interface ObserverWrapper<T> {

    void onNext(T t);

    void onError(Throwable e);

    void onComplete();

}
