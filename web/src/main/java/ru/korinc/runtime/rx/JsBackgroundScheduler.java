package ru.korinc.runtime.rx;

import ru.korinc.runtime.interop.scheduler.Scheduler;

/**
 * Created by gputintsev on 15.12.17.
 */

public class JsBackgroundScheduler implements BackgroundSchedulerWrapper {

    Scheduler mScheduler;

    public JsBackgroundScheduler() {
        mScheduler = Scheduler.async;
    }

    public Scheduler getScheduler() {
        return mScheduler;
    }
}
