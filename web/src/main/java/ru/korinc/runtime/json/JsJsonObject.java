package ru.korinc.runtime.json;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;

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
        return (source.containsKey(key) && source.get(key).isString() != null) ? source.get(key).isString().stringValue() : null;
    }

    @Override
    public Boolean getBoolean(String key, Boolean fallback) {
        return (source.containsKey(key) && source.get(key).isBoolean() != null) ? source.get(key).isBoolean().booleanValue() : fallback;

    }

    @Override
    public int getInteger(String key, int fallback) {
        return (source.containsKey(key) && source.get(key).isNumber() != null) ? ((int) source.get(key).isNumber().doubleValue())
                : fallback;
    }

    @Override
    public String getString(String key, String defaultValue) {
        return (source.containsKey(key) && source.get(key).isString() != null) ? source.get(key).isString().stringValue()
                : defaultValue;
    }

    @Override
    public JsonObjectWrapper putString(String key, String s) {
        source.put(key, new JSONString(s));
        return this;
    }

    @Override
    public JsonObjectWrapper putObject(String key, JsonObjectWrapper o) {
        source.put(key, ((JsJsonObject) o).source);
        return this;
    }

    @Override
    public String toJsonString() {
        return source.toString();
    }


}
