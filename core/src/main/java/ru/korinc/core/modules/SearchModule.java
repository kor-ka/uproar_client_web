package ru.korinc.core.modules;

import java.util.ArrayList;
import java.util.HashMap;

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


    private BSWrapper<ArrayList<String>> searchResults;

    @Override
    public void run() {
        ArrayList<String> defaultValue = new ArrayList<>();
        defaultValue.add("search some movies!");
        searchResults = mRxProvider.bs(defaultValue);

    }

    public void query(String query) {
        if (input == null) {
            input = mRxProvider.bs(query);

            ObservableWrapper<HttpResponse> httpResponseObservableWrapper = input.switchOnNext(
                    input.throttleLast(500).map(s -> HttpObserver
                            .get("http://www.omdbapi.com/?s=" + s, new String[]{})
                            .subscribeOn(mRxProvider.scheduler())));
            httpResponseObservableWrapper.map(httpResponse -> {
                ArrayList<String> res = new ArrayList<>();

                JsonArrayWrapper resp = json.getJson(new String(httpResponse.getContent()))
                        .getJsonArray("Search");
                if (resp == null) {
                    res.add("Movie not found :\'(");
                    return res;
                }
                String movieInfo;
                JsonObjectWrapper movieJson;
                for (int i = 0; i < resp.length(); i++) {
                    movieJson = resp.getJsonObjectWrapper(i);
                    movieInfo = movieJson.getString("Title");
                    movieInfo += "(year: " + movieJson.getString("Year") + ")";
                    res.add(movieInfo);
                }
                return res;
            })
                    .subscribeOn(mRxProvider.scheduler()).subscribe(
                    res -> searchResults.onNext(res));
        } else {
            input.onNext(query);
        }
    }

    public ObservableWrapper<ArrayList<String>> getSearchResults() {
        return searchResults;
    }
}
