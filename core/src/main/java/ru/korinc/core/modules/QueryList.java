package ru.korinc.core.modules;

import java.util.ArrayList;

import ru.korinc.core.entity.Query;
import ru.korinc.core.entity.SearchEntity;

/**
 * Created by gputintsev on 19.12.17.
 */

public class QueryList extends ArrayList<SearchEntity> {

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
