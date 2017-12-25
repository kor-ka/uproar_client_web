package ru.korinc.runtime.json;


/**
 * Created by gputintsev on 23.04.17.
 */

public interface JsonObjectWrapper {

    JsonObjectWrapper getJsonObject(String key) throws NullPointerException;

    JsonArrayWrapper getJsonArray(String key) throws NullPointerException;

    String getString(String key);

    int getInteger(String key, int fallback);

    String getString(String key, String defaultValue);

    JsonObjectWrapper putString(String key, String s);

    JsonObjectWrapper putObject(String key, JsonObjectWrapper o);

    String toJsonString();

}
