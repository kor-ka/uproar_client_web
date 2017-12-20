package ru.korinc.core;

import ru.korinc.core.modules.ModulesContext;
import ru.korinc.runtime.RuntimeConfiguration;

import static java.lang.Math.abs;

public class Model {

    private RuntimeConfiguration configuration;

    private ModulesContext mModulesContext;

    public Model(RuntimeConfiguration configuration) {
        this.configuration = configuration;
        mModulesContext = new ModulesContext(configuration);

        configuration.getLog().d("Model", "inited");
    }


}