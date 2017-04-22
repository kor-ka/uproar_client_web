package ru.korinc.core.modules;


import ru.korinc.runtime.RuntimeConfiguration;

/**
 * Created by gputintsev on 20.03.17.
 */

public class ModulesContext {

    private RuntimeConfiguration mRuntimeConfiguration;

    SearchModule mSearchModule;

    public ModulesContext(RuntimeConfiguration runtimeConfiguration) {
        mRuntimeConfiguration = runtimeConfiguration;
        mSearchModule = new SearchModule(this);
        mSearchModule.run();
    }

    protected RuntimeConfiguration getRuntimeConfiguration() {
        return mRuntimeConfiguration;
    }

    public SearchModule getSearchModule() {
        return mSearchModule;
    }
}
