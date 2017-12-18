package ru.korinc.runtime.json;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

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
        return (JsonObjectWrapper) source.get(key);
    }

    @Override
    public JsonArrayWrapper getJsonArray(String key) throws NullPointerException {
        return (JsonArrayWrapper) source.get(key);
    }

    @Override
    public String getString(String key) {
        return source.isString() != null ? source.isString().stringValue() : null;
    }

    @Override
    public String getString(String key, String defaultValue) {
        return source.isString() != null ? source.isString().stringValue() : defaultValue;
    }
}
