package ru.korinc.runtime;

import com.google.j2objc.annotations.ObjectiveCName;

import ru.korinc.runtime.logging.LogProvider;
import ru.korinc.runtime.rx.RxProvider;
import ru.korinc.runtime.timeout.TimeoutProvider;

/**
 * Created by gputintsev on 12.04.17.
 */

public class RuntimeConfiguration {

    private RxProvider mRxProvider;

    private TimeoutProvider mTimeoutProvider;

    private LogProvider mLogProvider;

    public RuntimeConfiguration(RxProvider rxProvider, TimeoutProvider timeoutProvider,
            LogProvider logProvider) {
        mRxProvider = rxProvider;
        mTimeoutProvider = timeoutProvider;
        mLogProvider = logProvider;
    }

    public RxProvider getRxProvider() {
        return mRxProvider;
    }

    public TimeoutProvider getTimeoutProvider() {
        return mTimeoutProvider;
    }

    public LogProvider getLogProvider() {
        return mLogProvider;
    }
}
