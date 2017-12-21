package ru.korinc.core.modules.player;

/**
 * Created by gputintsev on 21.12.17.
 */

public class Content {

    private String src = "";

    private String originalId = "";

    private boolean skipped = false;

    private boolean promoted = false;

    public Content(String src, String originalId) {
        this.src = src;
        this.originalId = originalId;
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
        return src == null;
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
}
