package ru.korinc.core;

import com.google.gwt.http.client.URL;

import ru.korinc.runtime.RuntimeConfiguration;
import ru.korinc.runtime.json.JsonPrivider;
import ru.korinc.runtime.logging.JsLog;
import ru.korinc.runtime.rx.JsRxProvider;
import ru.korinc.runtime.timeout.JsTimeout;
import ru.korinc.server.proxy.Http;

/**
 * Created by gputintsev on 20.03.17.
 */

public class AppCore {

    private static volatile AppCore core;

    private Model mModel;


    public static AppCore sharedCore() {
        if (core == null) {
            core = new AppCore();
            core.initCore();
        }
        return core;
    }


    public void initCore() {
        mModel = new Model(new RuntimeConfiguration().setRxProvider(new JsRxProvider())
                .setTimeoutProvider(new JsTimeout()).setLog(new JsLog()).setHttp(Http::new)
                .setJson(new JsonPrivider()).setEncoder(URL::encodeQueryString));
    }

    public Model getModel() {
        return mModel;
    }
}
