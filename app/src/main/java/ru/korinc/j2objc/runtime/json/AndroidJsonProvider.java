package ru.korinc.j2objc.runtime.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ru.korinc.runtime.json.JsonArrayWrapper;
import ru.korinc.runtime.json.JsonObjectWrapper;
import ru.korinc.runtime.json.JsonProvider;

/**
 * Created by gputintsev on 23.04.17.
 */

public class AndroidJsonProvider implements JsonProvider {

    @Override
    public JsonObjectWrapper getJson(String source) {
        try {
            return new AndroidJsonObject(new JSONObject(source));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JsonArrayWrapper getJsonArray(String spurce) {
        try {
            return new AndroidJsonArray(new JSONArray(spurce));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
