package ru.korinc.runtime.json;

/**
 * Created by gputintsev on 23.04.17.
 */

public interface JsonArrayWrapper {

    int length();

    JsonObjectWrapper getJsonObjectWrapper(int position);

    JsonArrayWrapper getJsonArrayWrapper(int position);

    String getString(int position);
}
