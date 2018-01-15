package ru.korinc.runtime.json;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsJsonArray implements JsonArrayWrapper {

    public JSONArray mArray;

    public JsJsonArray(JSONArray array) {
        mArray = array;
    }

    @Override
    public int length() {
        return mArray.size();
    }

    @Override
    public JsonObjectWrapper getJsonObjectWrapper(int position) {
        JSONObject object = mArray.get(position).isObject();
        return object != null ? new JsJsonObject(object) : null;
    }

    @Override
    public JsonArrayWrapper getJsonArrayWrapper(int position) {
        JSONArray array = mArray.get(position).isArray();
        return array != null ? new JsJsonArray(array) : null;
    }

    @Override
    public String getString(int position) {
        return mArray.get(position).isString().stringValue();
    }

    @Override
    public void add(Integer i) {
        mArray.set(mArray.size(), new JSONNumber(i));
    }
}
