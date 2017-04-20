package ru.korinc.j2objc.runtime.rx;

import io.reactivex.disposables.Disposable;
import ru.korinc.runtime.rx.DisposableWrapper;

/**
 * Created by gputintsev on 12.04.17.
 */

public class AndroidDisposable implements DisposableWrapper {

    private Disposable disposable;

    public AndroidDisposable(Disposable disposable) {
        this.disposable = disposable;
    }

    @Override
    public void dispose() {
        disposable.dispose();
    }
}
