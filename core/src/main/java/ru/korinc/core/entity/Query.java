package ru.korinc.core.entity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static ru.korinc.runtime.RuntimeConfiguration.encoder;

/**
 * Created by gputintsev on 03.05.17.
 */

public class Query {

    private int page = 1;

    private String title = "";

    public Query(int page, String title) {
        this.page = page;
        this.title = title;
    }

    private ArrayList<SearchEntity> oldResults = new ArrayList<SearchEntity>();

    public ArrayList<SearchEntity> getOldResults() {
        return oldResults;
    }

    public Query setOldResults(ArrayList<SearchEntity> oldResults) {
        this.oldResults = oldResults;
        return this;
    }

    public int getPage() {
        return page;
    }

    public Query setPage(int page) {
        this.page = page;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Query setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "http://www.omdbapi.com/?apikey=7b7f708c&s=" + encoder.encodeQueryString(title)
                + "&page=" + page;
    }
}
