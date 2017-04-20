package ru.korinc.j2objc.runtime.logging;

import android.util.Log;

import ru.korinc.runtime.logging.LogProvider;

/**
 * Created by gputintsev on 18.04.17.
 */

public class AndroidLogging implements LogProvider {

    @Override
    public void d(String tag, String msg) {
        Log.d(tag, msg);
    }
}
