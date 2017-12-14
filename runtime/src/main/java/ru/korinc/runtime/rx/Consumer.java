package ru.korinc.runtime.rx;


public interface Consumer<T> {

    void accept(T t) throws Exception;
}
