package ru.korinc.core.modules;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import ru.korinc.core.entity.Movie;
import ru.korinc.runtime.json.JsonArrayWrapper;
import ru.korinc.runtime.json.JsonObjectWrapper;
import ru.korinc.runtime.network.HttpObserver;
import ru.korinc.runtime.network.HttpResponse;
import ru.korinc.runtime.rx.ObservableWrapper;
import ru.korinc.runtime.rx.subject.BSWrapper;

import static ru.korinc.runtime.RuntimeConfiguration.json;
import static ru.korinc.runtime.RuntimeConfiguration.log;

/**
 * Created by gputintsev on 22.04.17.
 */

public class SearchModule extends ModuleBase {

    public SearchModule(ModulesContext context) {
        super(context);

    }

    private BSWrapper<String> input;


    private BSWrapper<ArrayList<Movie>> searchResults;

    @Override
    public void run() {
        ArrayList<Movie> defaultValue = new ArrayList<>();
        defaultValue.add(new Movie("search some movies!", ""));
        searchResults = mRxProvider.bs(defaultValue);

    }

    public void query(String query) {
        if (input == null) {
            input = mRxProvider.bs(query);

            ObservableWrapper<HttpResponse> httpResponseObservableWrapper = input
                    .switchOnNext(
                    input
                            .throttleLast(500)
                            .map(s -> HttpObserver
                            .get("http://www.omdbapi.com/?s=" + URLEncoder.encode(s, "UTF-8"), new String[]{})
                            .subscribeOn(mRxProvider.scheduler())
                            )
            );
            httpResponseObservableWrapper.map(httpResponse -> {
                ArrayList<Movie> res = new ArrayList<>();

                JsonArrayWrapper resp = json.getJson(new String(httpResponse.getContent()))
                        .getJsonArray("Search");
                if (resp == null) {
                    res.add(new Movie("Movie not found :\'(", ""));
                    return res;
                }
                Movie movieInfo;
                JsonObjectWrapper movieJson;
                for (int i = 0; i < resp.length(); i++) {
                    movieJson = resp.getJsonObjectWrapper(i);
                    movieInfo = new Movie(movieJson.getString("Title"),
                            movieJson.getString("Year") + " | " + movieJson.getString("Type"));
                    res.add(movieInfo);
                }
                return res;
            })
                    .subscribeOn(mRxProvider.scheduler()).subscribe(
                    res -> {
                        searchResults.onNext(res);
                        log.d("result", res.toString());
                    });
        } else {
            input.onNext(query);
        }
    }

    public ObservableWrapper<ArrayList<Movie>> getSearchResults() {
        return searchResults;
    }
}
