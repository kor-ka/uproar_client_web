package ru.korinc.core.modules;


import ru.korinc.runtime.RuntimeConfiguration;

/**
 * Created by gputintsev on 20.03.17.
 */

public class ModulesContext {

    private RuntimeConfiguration mRuntimeConfiguration;

    PlayerModule mPlayerModule;

    public ModulesContext(RuntimeConfiguration runtimeConfiguration) {
        mRuntimeConfiguration = runtimeConfiguration;
        mPlayerModule = new PlayerModule(this);

        mPlayerModule.run();
    }

    protected RuntimeConfiguration getRuntimeConfiguration() {
        return mRuntimeConfiguration;
    }

    public PlayerModule getPlayerModule() {
        return mPlayerModule;
    }
}
