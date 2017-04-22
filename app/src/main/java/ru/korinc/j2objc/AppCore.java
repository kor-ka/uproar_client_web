package ru.korinc.j2objc;

import ru.korinc.core.Model;
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
        mModel = new Model(new RuntimeConfiguration(new AndroidRxProvider(), new AndroidTimeout(),
                new AndroidLogging(), () -> new HttpMock(new Http())));
    }

    public Model getModel() {
        return mModel;
    }
}
