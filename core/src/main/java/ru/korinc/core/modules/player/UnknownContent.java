package ru.korinc.core.modules.player;

import ru.korinc.runtime.json.JsonObjectWrapper;

/**
 * Created by gputintsev on 25.12.17.
 */

public class UnknownContent extends Content {

    public UnknownContent(String src, Integer originalId, JsonObjectWrapper bag) {
        super(src, originalId, bag);
    }
}
