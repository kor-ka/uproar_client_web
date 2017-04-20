package ru.korinc.j2objc;


/**
 * Created by gputintsev on 20.03.17.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCore.sharedCore().initCore(this);
    }
}
