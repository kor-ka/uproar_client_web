package ru.korinc.runtime.json;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsonPrivider implements JsonProvider {

    @Override
    public JsonObjectWrapper getJson(String source) {
        return new JsJsonObject(source);
    }

    @Override
    public JsonArrayWrapper getJsonArray(String spurce) {
        return null;
    }
}
