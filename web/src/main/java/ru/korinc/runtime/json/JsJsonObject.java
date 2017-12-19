package ru.korinc.runtime.json;

import com.google.gwt.json.client.JSONArray;
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
        return new JsJsonObject((JSONObject) source.get(key));
    }

    @Override
    public JsonArrayWrapper getJsonArray(String key) throws NullPointerException {
        return new JsArray((JSONArray) source.get(key));
    }

    @Override
    public String getString(String key) {
        return source.get(key).isString() != null ? source.get(key).isString().stringValue() : null;
    }

    @Override
    public String getString(String key, String defaultValue) {
        return source.get(key).isString() != null ? source.get(key).isString().stringValue()
                : defaultValue;
    }
}
