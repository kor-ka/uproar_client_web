package ru.korinc.runtime.logging;

/**
 * Created by gputintsev on 18.04.17.
 */

public interface LogProvider {

    void d(String tag, String msg);

    void e(Throwable throwable);
}
