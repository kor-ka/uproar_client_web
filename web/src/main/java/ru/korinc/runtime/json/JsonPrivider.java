package ru.korinc.runtime.json;

import com.google.gwt.json.client.JSONArray;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsonPrivider implements JsonProvider {

    @Override
    public JsonObjectWrapper getJson(String source) {
        return new JsJsonObject(source);
    }

    @Override
    public JsonArrayWrapper getJsonArray() {
        return new JsJsonArray(new JSONArray());
    }
}
