package ru.korinc.core.entity;

/**
 * Created by gputintsev on 03.05.17.
 */

public class Movie extends SearchEntity {

    private String title;

    private String additionalInfo;

    public Movie(String title, String year) {
        this.title = title;
        this.additionalInfo = year;
    }

    public String getTitle() {
        return title;
    }

    public String additionalInfo() {
        return additionalInfo;
    }
}
