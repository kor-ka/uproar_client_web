package ru.korinc.utils;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by gputintsev on 20.03.17.
 */

public class Utils {

    public static <T> void apply(Iterable<T> source, Matcher<T> matcher, Apply<T> action) {
        apply(source, matcher, null, action);
    }

    public static <T> void apply(Iterable<T> source, Apply<T> action) {
        apply(source, null, null, action);
    }

    public static <T> void apply(Iterable<T> source, Matcher<T> matcher, Matcher<T> breakOn,
            Apply<T> action) {
        for (Iterator<T> iter = source.iterator(); iter.hasNext(); ) {
            T val = iter.next();
            if (matcher == null || matcher.match(val)) {
                action.apply(iter, val);
                if (breakOn != null && breakOn.match(val)) {
                    return;
                }
            }
        }
    }

    public static <T> SearchResult<T> arrayListFirst(ArrayList<T> source, Matcher<T> condition,
            ApplySearchResult<T> ifFound) {
        return arrayListFirst(source, condition, ifFound, null);
    }

    public static <T> SearchResult<T> arrayListFirst(ArrayList<T> source, Matcher<T> condition,
            ApplySearchResult<T> ifFound, Action not) {
        SearchResult<T> res = new SearchResult<>(-1, null);

        int position = -1;
        boolean found = false;
        for (T val : source) {
            if (condition.match(val)) {
                res = new SearchResult<>(++position, val);
                found = true;
                break;
            }
            position++;
        }

        if (found) {
            if (ifFound != null) {
                ifFound.apply(res);
            }
        } else {
            if (not != null) {
                not.call();
            }
        }

        return res;
    }

    public static class SearchResult<T> {

        private final int position;

        private final T item;

        public SearchResult(int position, T item) {
            this.position = position;
            this.item = item;
        }

        public int getPosition() {
            return position;
        }

        public T getItem() {
            return item;
        }
    }

    public interface Matcher<T> {

        boolean match(T val);
    }

    public interface ApplySearchResult<T> {

        void apply(SearchResult<T> val);
    }

    public interface Apply<T> {

        void apply(Iterator<T> iterator, T val);
    }

    public interface Action {

        void call();
    }
}
