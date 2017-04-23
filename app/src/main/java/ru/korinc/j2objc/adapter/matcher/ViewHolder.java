package ru.korinc.j2objc.adapter.matcher;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import io.reactivex.disposables.CompositeDisposable;
import ru.korinc.j2objc.adapter.DisposeListener;


/**
 * Created by gputintsev on 25.11.16.
 */

public class ViewHolder<T> extends RecyclerView.ViewHolder {


    private T data;

    protected CompositeDisposable binder;

    protected ViewGroup root;


    public ViewHolder(View itemView, ViewGroup root, CompositeDisposable binder) {
        super(preInit(itemView));
        this.root = root;
        this.binder = binder;
        binder.add(new DisposeListener<>(this, tag -> unbind()));
    }

    private static View preInit(View itemView) {
        if (itemView.getLayoutParams() == null) {
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        return itemView;
    }


    public void bind(T data) {
        bind(data, false);
    }

    public void bind(T data, boolean first) {
        if (data.equals(this.data)) {
            return;
        }
        unbind();
        internalBind(data, first);
        this.data = data;
    }

    private void internalBind(T data, boolean first) {
        setupFirst(first);
        performBind(data);
    }

    private boolean isFirst = false;

    protected void setupFirst(boolean isFirst) {

    }

    protected void performBind(T data) {

    }

    protected void unbind() {

    }

}
