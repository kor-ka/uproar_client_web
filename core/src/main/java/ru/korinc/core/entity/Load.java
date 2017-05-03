package ru.korinc.core.entity;

/**
 * Created by gputintsev on 03.05.17.
 */

public class Load extends SearchEntity {

    private Query query;

    public Load(Query query) {
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }
}
