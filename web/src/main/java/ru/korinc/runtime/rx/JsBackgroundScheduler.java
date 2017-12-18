package ru.korinc.runtime.rx;

import com.github.timofeevda.gwt.rxjs.interop.scheduler.Scheduler;

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
