package ru.korinc.j2objc.runtime.rx;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import ru.korinc.runtime.rx.BackgroundSchedulerWrapper;

/**
 * Created by gputintsev on 19.04.17.
 */

public class AndroidBackgroundScheduler implements BackgroundSchedulerWrapper {

    private Scheduler mScheduler;

    public AndroidBackgroundScheduler() {
        mScheduler = Schedulers.io();
    }

    public Scheduler getScheduler() {
        return mScheduler;
    }
}
