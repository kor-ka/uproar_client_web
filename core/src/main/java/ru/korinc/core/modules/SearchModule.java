package ru.korinc.core.modules;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import ru.korinc.core.entity.Load;
import ru.korinc.core.entity.Movie;
import ru.korinc.core.entity.Query;
import ru.korinc.core.entity.SearchEntity;
import ru.korinc.core.entity.SearchResults;
import ru.korinc.runtime.json.JsonArrayWrapper;
import ru.korinc.runtime.json.JsonObjectWrapper;
import ru.korinc.runtime.network.HttpObserver;
import ru.korinc.runtime.network.HttpResponse;
import ru.korinc.runtime.rx.Consumer;
import ru.korinc.runtime.rx.Function;
import ru.korinc.runtime.rx.ObservableWrapper;
import ru.korinc.runtime.rx.subject.BSWrapper;
import ru.korinc.utils.Touple;

import static ru.korinc.runtime.RuntimeConfiguration.json;
import static ru.korinc.runtime.RuntimeConfiguration.log;

/**
 * Created by gputintsev on 22.04.17.
 */

public class SearchModule extends ModuleBase {

    public SearchModule(ModulesContext context) {
        super(context);

    }

    private BSWrapper<Query> input;


    private BSWrapper<ArrayList<SearchEntity>> searchResults;

    @Override
    public void run() {
        ArrayList<SearchEntity> defaultValue = new ArrayList<>();
        defaultValue.add(new Movie("search some movies!", ""));
        searchResults = mRxProvider.bs(defaultValue);

    }

    public void query(String query) {
        query(new Query(1, query));
    }

    private Query lastQuery;

    public void query(Query query) {

        // skip page change if query changed
        if (lastQuery != null && query.getPage() > 1 && !query.getTitle()
                .endsWith(lastQuery.getTitle())) {
            return;
        }

        if (lastQuery == null || !lastQuery.getTitle().equals(query.getTitle())) {
            ArrayList<SearchEntity> empty = new ArrayList<>();
            empty.add(new Movie("Loading...", ""));
            searchResults.onNext(empty);
        }

        lastQuery = query;

        if (input == null) {
            input = mRxProvider.bs(query);

            ObservableWrapper<ArrayList<SearchEntity>> httpResponseObservableWrapper = input
                    .switchOnNext(input.throttleLast(500)
                            .map(s -> HttpObserver.get(s.toString(), new String[]{})
                                    .map(httpResponse -> new Touple<>(s, httpResponse))
                                    .map(respAndQuery -> {
                                        ArrayList<SearchEntity> res = new ArrayList<>();

                                        JsonArrayWrapper resp = json
                                                .getJson(respAndQuery.getB().getContent())
                                                .getJsonArray("Search");
                                        if (resp == null) {
                                            res.addAll(respAndQuery.getA().getOldResults());
                                            if (res.size() == 0) {
                                                res.add(new Movie("Movie not found :\'(", ""));
                                            }
                                            return res;
                                        }
                                        JsonObjectWrapper movieJson;
                                        for (int i = 0; i < resp.length(); i++) {
                                            final Movie movieInfo;
                                            movieJson = resp.getJsonObjectWrapper(i);
                                            String subtitle = movieJson.getString("Year") + " | "
                                                    + movieJson.getString("Type");
                                            movieInfo = new Movie(movieJson.getString("Title"),
                                                    subtitle);

                                            //TODO get Plot from http://www.omdbapi.com/?i=imdbID

                                        }

                                        res.addAll(0, respAndQuery.getA().getOldResults());

                                        Query q = respAndQuery.getA();
                                        q.setPage(respAndQuery.getA().getPage() + 1);
                                        ArrayList<SearchEntity> oldResults = new ArrayList<>(res);
                                        q.setOldResults(oldResults);
                                        res.add(new Load(q));

                                        return res;
                                    }).subscribeOn(mRxProvider.scheduler())));
            httpResponseObservableWrapper.subscribeOn(mRxProvider.scheduler()).subscribe(res -> {
                searchResults.onNext(res);
                log.d("result", res.toString());
            });
        } else {
            input.onNext(query);
        }
    }

    public ObservableWrapper<ArrayList<SearchEntity>> getSearchResults() {
        return searchResults;
    }
}
