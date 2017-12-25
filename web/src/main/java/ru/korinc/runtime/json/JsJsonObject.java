package ru.korinc.runtime.json;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsJsonObject implements JsonObjectWrapper {

    private JSONObject source;

    public JsJsonObject(String source) {
        this.source = (JSONObject) JSONParser.parseStrict(source);
    }

    public JsJsonObject(JSONObject source) {
        this.source = source;
    }

    @Override
    public JsonObjectWrapper getJsonObject(String key) throws NullPointerException {
        JSONObject object = (JSONObject) this.source.get(key);
        return object != null ? new JsJsonObject(object) : null;
    }

    @Override
    public JsonArrayWrapper getJsonArray(String key) throws NullPointerException {
        JSONArray array = (JSONArray) source.get(key);
        return array != null ? new JsJsonArray(array) : null;
    }

    @Override
    public String getString(String key) {
        return source.get(key).isString() != null ? source.get(key).isString().stringValue() : null;
    }

    @Override
    public int getInteger(String key, int fallback) {
        return source.get(key).isNumber() != null ? ((int) source.get(key).isNumber().doubleValue())
                : fallback;
    }

    @Override
    public String getString(String key, String defaultValue) {
        return source.get(key).isString() != null ? source.get(key).isString().stringValue()
                : defaultValue;
    }
}
