package ru.korinc.j2objc.adapter.matcher;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gputintsev on 25.11.16.
 */
public abstract class CustomLayouter<T> implements FieldLayouter<T> {

    protected ViewHolderCreator<T> mCreator;

    protected Matcher<T> mMatcher;

    public CustomLayouter(Matcher<T> matcher, ViewHolderCreator<T> creator) {
        mCreator = creator;
        mMatcher = matcher;
    }

    @Override
    public boolean isMatch(T data) {
        return mMatcher.match(data);
    }

    @Override
    public ViewHolder<T> onCreateViewHolder(ViewGroup root) {
        return mCreator.onCreateViewHolder(root);
    }

    public interface ViewHolderCreator<T> {

        ViewHolder<T> onCreateViewHolder(View view);
    }

    public interface Matcher<T> {

        boolean match(T data);
    }
}
