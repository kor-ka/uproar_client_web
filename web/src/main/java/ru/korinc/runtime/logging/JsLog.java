package ru.korinc.runtime.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsLog implements LogProvider {

    Logger logger = Logger.getLogger("NameOfYourLogger");

    @Override
    public void d(String tag, String msg) {
        logger.log(Level.INFO, msg);
    }

    @Override
    public void e(Throwable throwable) {
        logger.log(Level.INFO, "EX! " + throwable.toString());
    }
}
