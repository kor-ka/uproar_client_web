package ru.korinc.core.modules;

import java.util.ArrayList;

import ru.korinc.core.entity.Query;

/**
 * Created by gputintsev on 19.12.17.
 */

public class QueryList<T> extends ArrayList<T> {

    private final Query mQuery;

    public QueryList(Query q) {
        this.mQuery = q;
    }

    public QueryList() {
        mQuery = new Query();
    }

    public Query getQuery() {
        return mQuery;
    }
}
