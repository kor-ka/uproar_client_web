package ru.korinc.core.modules;

import java.util.ArrayList;

import ru.korinc.core.entity.Load;
import ru.korinc.core.entity.Movie;
import ru.korinc.core.entity.SearchEntity;
import ru.korinc.runtime.json.JsonArrayWrapper;
import ru.korinc.runtime.json.JsonObjectWrapper;
import ru.korinc.runtime.network.HttpObserver;
import ru.korinc.runtime.rx.ObservableWrapper;
import ru.korinc.runtime.rx.subject.BSWrapper;
import ru.korinc.core.utils.Touple;

import static ru.korinc.runtime.RuntimeConfiguration.json;
import static ru.korinc.runtime.RuntimeConfiguration.log;

/**
 * Created by gputintsev on 22.04.17.
 */

public class SearchModule extends ModuleBase {

    public SearchModule(ModulesContext context) {
        super(context);

    }

    private BSWrapper<ru.korinc.core.entity.Query> input;


    private BSWrapper<QueryList<SearchEntity>> searchResults;

    @Override
    public void run() {
        QueryList<SearchEntity> defaultValue = new QueryList<>();
        defaultValue.add(new Movie("search some movies!", ""));
        searchResults = mRxProvider.bs(defaultValue);

    }

    private int generation = 0;


    public void query(String query) {
        query(new ru.korinc.core.entity.Query(1, query).setGeneration(++generation));
    }

    private ru.korinc.core.entity.Query lastQuery;


    public void query(ru.korinc.core.entity.Query query) {


        log.d("SearchModule", "new query:" + query.toString());

        // skip page change if query changed
        if (lastQuery != null && query.getPage() > 1 && !query.getTitle()
                .endsWith(lastQuery.getTitle())) {
            return;
        }

        if (lastQuery == null || !lastQuery.getTitle().equals(query.getTitle())) {
            QueryList<SearchEntity> empty = new QueryList<>();
            empty.add(new Movie("Loading...", ""));
            searchResults.onNext(empty);
        }

        lastQuery = query;

        if (input == null) {
            log.d("SearchModule", "create bs");
            input = mRxProvider.bs(query);
            log.d("SearchModule", "bs created");

            log.d("SearchModule", "switchOnNext");

            ObservableWrapper<QueryList<SearchEntity>> httpResponseObservableWrapper = input
                    .switchOnNext(input.throttleLast(500)
                            .map(s -> HttpObserver.get(s.toString(), new String[]{})
                                    .map(httpResponse -> new Touple<>(s, httpResponse))
                                    .map(respAndQuery -> {

                                        QueryList<SearchEntity> res = new QueryList<>(
                                                respAndQuery.getA());

                                        JsonArrayWrapper resp = json
                                                .getJson(respAndQuery.getB().getContent())
                                                .getJsonArray("Search");
                                        log.d("SearchModule", "resp:" + resp);
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
                                            res.add(movieInfo);
                                        }

                                        res.addAll(0, respAndQuery.getA().getOldResults());

                                        ru.korinc.core.entity.Query q = respAndQuery.getA();
                                        q.setPage(respAndQuery.getA().getPage() + 1);
                                        ArrayList<SearchEntity> oldResults = new ArrayList<>(res);
                                        q.setOldResults(oldResults);
                                        res.add(new Load(q));

                                        return res;
                                    }).subscribeOn(mRxProvider.scheduler())));
            log.d("SearchModule", "switchOnNext created");

            httpResponseObservableWrapper.subscribeOn(mRxProvider.scheduler()).subscribe(res -> {
                searchResults.onNext(res);
            });
        } else {
            log.d("SearchModule", "new input:" + query.toString());

            input.onNext(query);
        }
    }

    public ObservableWrapper<QueryList<SearchEntity>> getSearchResults() {
        return searchResults;
    }
}
