package ru.korinc.runtime.json;


/**
 * Created by gputintsev on 23.04.17.
 */

public interface JsonObjectWrapper {

    JsonObjectWrapper getJsonObject(String key) throws NullPointerException;

    JsonArrayWrapper getJsonArray(String key) throws NullPointerException;

    String getString(String key);

    String getString(String key, String defaultValue);

}
