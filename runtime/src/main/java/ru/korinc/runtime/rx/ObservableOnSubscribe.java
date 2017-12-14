package ru.korinc.runtime.rx;

public interface ObservableOnSubscribe<T> {

    void subscribe(Emitter<T> e) throws Exception;
}

