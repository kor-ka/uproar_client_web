package ru.korinc.core.modules.player;

import ru.korinc.runtime.json.JsonObjectWrapper;

/**
 * Created by gputintsev on 21.12.17.
 */

public class YoutubeContent extends Content {

    public YoutubeContent(String src, String originalId, JsonObjectWrapper bag) {
        super(extractLink(src), originalId, bag);
    }

    private static String extractLink(String src) {
        String[] split = src.split("v=");
        return "http://www.youtube.com/v/" + split[1] + "?version=3";
    }
}
