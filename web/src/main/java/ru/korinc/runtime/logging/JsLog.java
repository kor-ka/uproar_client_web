package ru.korinc.runtime.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsLog implements LogProvider {

    private Logger logger = Logger.getLogger("DEFAULT");

    @Override
    public void d(String tag, String msg) {
        consoleLog(tag, msg);
    }

    @Override
    public void e(Throwable throwable) {
        consoleLog("EX", throwable.toString());
    }


    native void consoleLog(String tag, String message) /*-{
      console.log( tag + " " + message );
  }-*/;
}
