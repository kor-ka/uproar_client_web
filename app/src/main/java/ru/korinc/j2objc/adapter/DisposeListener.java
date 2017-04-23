package ru.korinc.j2objc.adapter;

import io.reactivex.disposables.Disposable;

/**
 * Created by gputintsev on 29.03.17.
 */

public class DisposeListener<T> implements Disposable {

    private DisposeListenerCallback<T> mCallback;

    private T tag;

    public DisposeListener(T tag, DisposeListenerCallback<T> callback) {
        mCallback = callback;
        this.tag = tag;
    }

    boolean disposed = false;

    @Override
    public void dispose() {
        mCallback.onDispose(tag);
        disposed = true;
    }

    @Override
    public boolean isDisposed() {
        return disposed;
    }

    public interface DisposeListenerCallback<T> {

        void onDispose(T tag);
    }
}
