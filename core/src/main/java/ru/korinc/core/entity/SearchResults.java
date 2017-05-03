package ru.korinc.core.entity;

import java.util.ArrayList;

/**
 * Created by gputintsev on 03.05.17.
 */

public class SearchResults extends ArrayList<SearchEntity> {

    private Query mQuery;

    public SearchResults(Query query) {
        mQuery = query;
    }

    public Query getQuery() {
        return mQuery;
    }
}
