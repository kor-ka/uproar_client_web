package ru.korinc.runtime.json;

import com.google.gwt.json.client.JSONArray;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsArray implements JsonArrayWrapper {

    private JSONArray mArray;

    public JsArray(JSONArray array) {
        mArray = array;
    }

    @Override
    public int length() {
        return mArray.size();
    }

    @Override
    public JsonObjectWrapper getJsonObjectWrapper(int position) {
        return new JsJsonObject(mArray.get(position).isObject());
    }

    @Override
    public JsonArrayWrapper getJsonArrayWrapper(int position) {
        return new JsArray(mArray.get(position).isArray());
    }

    @Override
    public String getString(int position) {
        return mArray.get(position).isString().stringValue();
    }
}
