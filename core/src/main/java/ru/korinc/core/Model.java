package ru.korinc.core;

import java.util.ArrayList;

import ru.korinc.core.entity.Movie;
import ru.korinc.core.entity.Query;
import ru.korinc.core.entity.SearchEntity;
import ru.korinc.core.modules.ModulesContext;
import ru.korinc.runtime.RuntimeConfiguration;
import ru.korinc.runtime.logging.LogProvider;
import ru.korinc.runtime.rx.Consumer;
import ru.korinc.runtime.rx.Emitter;
import ru.korinc.runtime.rx.Function;
import ru.korinc.runtime.rx.ObservableOnSubscribe;
import ru.korinc.runtime.rx.ObservableWrapper;
import ru.korinc.runtime.rx.subject.BSWrapper;

import static java.lang.Math.abs;

public class Model {

    private RuntimeConfiguration configuration;

    private ModulesContext mModulesContext;

    public Model(RuntimeConfiguration configuration) {
        this.configuration = configuration;
        mModulesContext = new ModulesContext(configuration);
    }


    public void searchMovieByTitleQuery(String query) {
        mModulesContext.getSearchModule().query(query);
    }

    public void searchMovieByTitleQuery(Query query) {
        mModulesContext.getSearchModule().query(query);
    }

    public ObservableWrapper<ArrayList<SearchEntity>> getSearchResults() {
        return mModulesContext.getSearchModule().getSearchResults();
    }

}
