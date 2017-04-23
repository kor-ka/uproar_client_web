package ru.korinc.j2objc.runtime.json;

import org.json.JSONException;
import org.json.JSONObject;

import ru.korinc.runtime.json.JsonArrayWrapper;
import ru.korinc.runtime.json.JsonObjectWrapper;

/**
 * Created by gputintsev on 23.04.17.
 */

public class AndroidJsonObject implements JsonObjectWrapper {

    private JSONObject source;

    public AndroidJsonObject(JSONObject source) {
        this.source = source;
    }

    @Override
    public JsonObjectWrapper getJsonObject(String key) {
        try {
            return new AndroidJsonObject(source.getJSONObject(key));
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public JsonArrayWrapper getJsonArray(String key) {
        try {
            return new AndroidJsonArray(source.getJSONArray(key));
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public String getString(String key) {
        try {
            return source.getString(key);
        } catch (JSONException e) {
            return "";
        }
    }

    @Override
    public String getString(String key, String defaultValue) {
        try {
            return source.getString(key);
        } catch (JSONException e) {
            return defaultValue;
        }
    }
}
