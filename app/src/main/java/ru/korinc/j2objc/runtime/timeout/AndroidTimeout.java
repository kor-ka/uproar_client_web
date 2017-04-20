package ru.korinc.j2objc.runtime.timeout;

import ru.korinc.runtime.timeout.TimeoutProvider;

/**
 * Created by gputintsev on 18.04.17.
 */

public class AndroidTimeout implements TimeoutProvider {

    @Override
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
