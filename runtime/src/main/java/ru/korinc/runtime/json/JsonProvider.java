package ru.korinc.runtime.json;


/**
 * Created by gputintsev on 23.04.17.
 */

public interface JsonProvider {

    JsonObjectWrapper getJson(String source);

    JsonArrayWrapper getJsonArray(String spurce);
}
