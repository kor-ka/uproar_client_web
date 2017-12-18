package ru.korinc.runtime.rx;

import com.github.timofeevda.gwt.rxjs.interop.subscription.Subscription;

/**
 * Created by gputintsev on 15.12.17.
 */

public class JsDisposable implements DisposableWrapper {

    Subscription mSubscription;

    public JsDisposable(Subscription subscription) {
        mSubscription = subscription;
    }

    @Override
    public void dispose() {
        mSubscription.unsubscribe();
    }
}
