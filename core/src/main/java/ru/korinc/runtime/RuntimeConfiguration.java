package ru.korinc.runtime;

import ru.korinc.runtime.logging.LogProvider;
import ru.korinc.runtime.network.HttpProvider;
import ru.korinc.runtime.rx.RxProvider;
import ru.korinc.runtime.timeout.TimeoutProvider;

/**
 * Created by gputintsev on 12.04.17.
 */

public class RuntimeConfiguration {

    public static RxProvider rxProvider;

    public static TimeoutProvider timeoutProvider;

    public static LogProvider log;

    public static HttpProvider http;

    public RuntimeConfiguration(RxProvider rxProvider, TimeoutProvider timeoutProvider,
            LogProvider logProvider, HttpProvider httpProvider) {
        RuntimeConfiguration.rxProvider = rxProvider;
        RuntimeConfiguration.timeoutProvider = timeoutProvider;
        RuntimeConfiguration.log = logProvider;
        RuntimeConfiguration.http = httpProvider;
    }

    public RxProvider getRxProvider() {
        return rxProvider;
    }

    public TimeoutProvider getTimeoutProvider() {
        return timeoutProvider;
    }

    public LogProvider getLogProvider() {
        return log;
    }
}
