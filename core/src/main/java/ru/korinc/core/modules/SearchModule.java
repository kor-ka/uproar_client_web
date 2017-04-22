package ru.korinc.core.modules;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import ru.korinc.runtime.network.HTTPResponse;
import ru.korinc.runtime.network.HttpObserver;
import ru.korinc.runtime.rx.Consumer;
import ru.korinc.runtime.rx.Function;
import ru.korinc.runtime.rx.ObservableWrapper;
import ru.korinc.runtime.rx.RxProvider;
import ru.korinc.runtime.rx.subject.BSWrapper;

/**
 * Created by gputintsev on 22.04.17.
 */

public class SearchModule extends ModuleBase {

    public SearchModule(ModulesContext context) {
        super(context);

    }

    private BSWrapper<String> input;

    private BSWrapper<String> searchResults;

    @Override
    public void run() {
        searchResults = mRxProvider.bs("");

    }

    public void query(String query) {
        if (input == null) {
            input = mRxProvider.bs(query);

            input.throttleFirst(500).flatMap(s -> HttpObserver.get("http://www.omdbapi.com/?t=" + s,
                            new HashMap<>())).subscribeOn(mRxProvider.scheduler()).subscribe(
                    httpResponse -> searchResults.onNext(new String(httpResponse.getContent())));
        } else {
            input.onNext(query);
        }
    }

    public ObservableWrapper<String> getSearchResults() {
        return searchResults;
    }
}
