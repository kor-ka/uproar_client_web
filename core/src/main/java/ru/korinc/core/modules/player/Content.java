package ru.korinc.core.modules.player;

import ru.korinc.runtime.json.JsonObjectWrapper;

import static ru.korinc.runtime.RuntimeConfiguration.log;

/**
 * Created by gputintsev on 21.12.17.
 */

public class Content {

    private String src = "dummy";

    private String originalId = "";

    private boolean skipped = false;

    private boolean promoted = false;

    private JsonObjectWrapper bag;

    private String action;

    public Content(String src, String originalId, JsonObjectWrapper bag) {
        this.src = src;
        this.originalId = originalId;
        this.bag = bag;
    }

    private Content() {

    }

    public String getSrc() {
        return src;
    }

    public boolean isSkipped() {
        return skipped;
    }

    public Content setSkipped(boolean skipped) {
        this.skipped = skipped;
        return this;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public Content setPromoted(boolean promoted) {
        this.promoted = promoted;
        return this;
    }

    public String getOriginalId() {
        return originalId;
    }

    public static Content dummy() {
        return new Content();
    }

    public boolean isDummy() {
        return "dummy".equals(src);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Content content = (Content) o;

        if (src != null ? !src.equals(content.src) : content.src != null) {
            return false;
        }
        return originalId != null ? originalId.equals(content.originalId)
                : content.originalId == null;
    }

    @Override
    public int hashCode() {
        int result = src != null ? src.hashCode() : 0;
        result = 31 * result + (originalId != null ? originalId.hashCode() : 0);
        return result;
    }

    public static Content fromJson(JsonObjectWrapper json) {
        JsonObjectWrapper audio = json.getJsonObject("audio");
        JsonObjectWrapper youtubeLink = json.getJsonObject("youtube_link");
        if (audio != null) {
            log.d("Content", "as audio");
            return new Mp3Content(audio.getString("track_url"),
                    Integer.toString(audio.getInteger("orig", -1)), audio);
        } else if (youtubeLink != null) {
            log.d("Content", "as video");
            return new YoutubeContent(youtubeLink.getString("url"),
                    Integer.toString(youtubeLink.getInteger("orig", -1)), youtubeLink);
        }

        log.d("Content", "as UnknownContent");
        return new UnknownContent("", "unknown", json);
    }

    public JsonObjectWrapper getBag() {
        return bag;
    }

    public String getAction() {
        return action;
    }

    public Content setAction(String action) {
        this.action = action;
        return this;
    }
}
