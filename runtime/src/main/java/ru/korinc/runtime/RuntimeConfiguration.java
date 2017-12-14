package ru.korinc.runtime;

import ru.korinc.runtime.json.JsonProvider;
import ru.korinc.runtime.logging.LogProvider;
import ru.korinc.runtime.network.HttpProvider;
import ru.korinc.runtime.rx.RxProvider;
import ru.korinc.runtime.timeout.TimeoutProvider;
import ru.korinc.runtime.utils.UrlEncoderProvider;

/**
 * Created by gputintsev on 12.04.17.
 */

public class RuntimeConfiguration {

    public static RxProvider rxProvider;

    public static TimeoutProvider timeoutProvider;

    public static LogProvider log;

    public static HttpProvider http;

    public static JsonProvider json;

    public static UrlEncoderProvider encoder;

    public RuntimeConfiguration() {
    }

    public RxProvider getRxProvider() {
        return rxProvider;
    }

    public RuntimeConfiguration setRxProvider(RxProvider rxProvider) {
        RuntimeConfiguration.rxProvider = rxProvider;
        return this;
    }

    public TimeoutProvider getTimeoutProvider() {
        return timeoutProvider;
    }

    public RuntimeConfiguration setTimeoutProvider(TimeoutProvider timeoutProvider) {
        RuntimeConfiguration.timeoutProvider = timeoutProvider;
        return this;
    }

    public LogProvider getLog() {
        return log;
    }

    public RuntimeConfiguration setLog(LogProvider log) {
        RuntimeConfiguration.log = log;
        return this;
    }

    public HttpProvider getHttp() {
        return http;
    }

    public RuntimeConfiguration setHttp(HttpProvider http) {
        RuntimeConfiguration.http = http;
        return this;
    }

    public JsonProvider getJson() {
        return json;
    }

    public RuntimeConfiguration setJson(JsonProvider json) {
        RuntimeConfiguration.json = json;
        return this;
    }

    public UrlEncoderProvider getEncoder() {
        return encoder;
    }

    public RuntimeConfiguration setEncoder(UrlEncoderProvider encoder) {
        RuntimeConfiguration.encoder = encoder;
        return this;
    }
}
