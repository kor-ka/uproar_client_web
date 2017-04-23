package ru.korinc.j2objc.runtime.json;

import org.json.JSONArray;
import org.json.JSONException;

import ru.korinc.runtime.json.JsonArrayWrapper;
import ru.korinc.runtime.json.JsonObjectWrapper;

/**
 * Created by gputintsev on 23.04.17.
 */

class AndroidJsonArray implements JsonArrayWrapper {

    private JSONArray source;

    public AndroidJsonArray(JSONArray source) {
        this.source = source;
    }

    @Override
    public int length() {
        return source.length();
    }

    @Override
    public JsonObjectWrapper getJsonObjectWrapper(int position) {
        try {
            return new AndroidJsonObject(source.getJSONObject(position));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JsonArrayWrapper getJsonArrayWrapper(int position) {
        try {
            return new AndroidJsonArray(source.getJSONArray(position));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getString(int position) {
        return null;
    }
}
