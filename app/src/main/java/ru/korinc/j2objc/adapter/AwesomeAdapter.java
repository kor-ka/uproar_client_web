package ru.korinc.j2objc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.korinc.j2objc.adapter.matcher.ViewHolder;
import ru.korinc.j2objc.adapter.matcher.ViewHolderMatcher;
import ru.korinc.j2objc.adapter.matcher.XMLLayouter;


/**
 * Created by gputintsev on 25.11.16.
 */

public class AwesomeAdapter<T> extends RecyclerView.Adapter<ViewHolder<T>> {

    private ArrayList<T> list = new ArrayList<>();

    private ViewHolderMatcher<T> mMatcher;

    public AwesomeAdapter() {
        this.mMatcher = new ViewHolderMatcher<>();

    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

    public ArrayList<T> getList() {
        return list;
    }

    @Override
    public int getItemViewType(int position) {
        return mMatcher.getMatchId(list.get(position));
    }

    @Override
    public ViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {

        return mMatcher.onCreateViewHolder(viewType, parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder<T> holder, int position) {
        holder.bind(list.get(position), position == 0);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public ViewHolderMatcher<T> getMatcher() {
        return mMatcher;
    }

    public void addHolder(Class<? extends T> data, XMLLayouter.Creator<T> creator, int layout) {
        mMatcher.add(new XMLLayouter<T>(d -> d.getClass().isAssignableFrom(data), creator, layout));
    }
}
