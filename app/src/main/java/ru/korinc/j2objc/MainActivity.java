package ru.korinc.j2objc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import ru.korinc.core.Model;
import ru.korinc.core.entity.Load;
import ru.korinc.core.entity.Movie;
import ru.korinc.core.entity.SearchEntity;
import ru.korinc.j2objc.adapter.AwesomeAdapter;
import ru.korinc.j2objc.adapter.matcher.ViewHolder;
import ru.korinc.j2objc.runtime.rx.AndroidObservable;
import ru.korinc.runtime.rx.Consumer;

public class MainActivity extends AppCompatActivity {


    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = AppCore.sharedCore().getModel();

        final EditText input = (EditText) findViewById(R.id.input);
        final RecyclerView res = (RecyclerView) findViewById(R.id.list);

        CompositeDisposable binder = new CompositeDisposable();
        AwesomeAdapter<SearchEntity> adapter = new AwesomeAdapter<>();
        adapter.addHolder(Movie.class, (v, root) -> new MovieHolder(v, root, binder),
                R.layout.entry);

        adapter.addHolder(Load.class, (v, root) -> new LoadHolder(v, root, binder), R.layout.load);

        res.setLayoutManager(new LinearLayoutManager(this));
        res.setAdapter(adapter);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                AppCore.sharedCore().getModel().searchMovieByTitleQuery(s.toString());
            }
        });
        input.setText("Star Wars");

        ((AndroidObservable<ArrayList<SearchEntity>>) model.getSearchResults()).getSource()
                .observeOn(AndroidSchedulers.mainThread()).subscribe(strings -> {
            adapter.setList(strings);
            adapter.notifyDataSetChanged();
        });

    }

    private static class MovieHolder extends ViewHolder<Movie> {

        private TextView tv;

        private TextView descr;

        public MovieHolder(View itemView, ViewGroup root, CompositeDisposable binder) {
            super(itemView, root, binder);
            tv = (TextView) itemView.findViewById(R.id.title);
            descr = (TextView) itemView.findViewById(R.id.description);
        }

        @Override
        protected void performBind(Movie data) {
            super.performBind(data);
            tv.setText(data.getTitle());
            descr.setText(data.additionalInfo());
        }
    }

    private static class LoadHolder extends ViewHolder<Load> {

        public LoadHolder(View itemView, ViewGroup root, CompositeDisposable binder) {
            super(itemView, root, binder);
        }

        @Override
        protected void performBind(Load data) {
            super.performBind(data);
            AppCore.sharedCore().getModel().searchMovieByTitleQuery(data.getQuery());
        }
    }
}