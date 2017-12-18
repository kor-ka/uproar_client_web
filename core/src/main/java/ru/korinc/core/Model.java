package ru.korinc.core;

import java.util.ArrayList;

import ru.korinc.core.entity.Movie;
import ru.korinc.core.entity.Query;
import ru.korinc.core.entity.SearchEntity;
import ru.korinc.core.modules.ModulesContext;
import ru.korinc.runtime.RuntimeConfiguration;
import ru.korinc.runtime.rx.ObservableWrapper;

import static java.lang.Math.abs;

public class Model {

    private RuntimeConfiguration configuration;

    private ModulesContext mModulesContext;

    public Model(RuntimeConfiguration configuration) {
        this.configuration = configuration;
        mModulesContext = new ModulesContext(configuration);

        configuration.getLog().d("Model", "inited");
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