package ru.korinc.j2objc;

import java.io.UnsupportedEncodingException;

import ru.korinc.core.Model;
import ru.korinc.j2objc.runtime.json.AndroidJsonProvider;
import ru.korinc.j2objc.runtime.logging.AndroidLogging;
import ru.korinc.j2objc.runtime.network.Http;
import ru.korinc.j2objc.runtime.network.mok.HttpMock;
import ru.korinc.j2objc.runtime.rx.AndroidRxProvider;
import ru.korinc.j2objc.runtime.timeout.AndroidTimeout;
import ru.korinc.runtime.RuntimeConfiguration;

/**
 * Created by gputintsev on 20.03.17.
 */

public class AppCore {

    private static volatile AppCore core = new AppCore();

    private Model mModel;


    public static AppCore sharedCore() {
        return core;
    }


    public void initCore(android.app.Application application) {
        mModel = new Model(new RuntimeConfiguration().setRxProvider(new AndroidRxProvider())
                .setTimeoutProvider(new AndroidTimeout()).setLog(new AndroidLogging())
                .setHttp(() -> new HttpMock(new Http())).setJson(new AndroidJsonProvider())
                .setEncoder(s -> {
                    try {
                        return java.net.URLEncoder.encode(s, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    return s;
                }));
    }

    public Model getModel() {
        return mModel;
    }
}
