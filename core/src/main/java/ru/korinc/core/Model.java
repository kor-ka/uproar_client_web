package ru.korinc.core;

import ru.korinc.core.modules.ModulesContext;
import ru.korinc.core.modules.player.Content;
import ru.korinc.core.modules.player.PlayerActor;
import ru.korinc.runtime.RuntimeConfiguration;
import ru.korinc.runtime.rx.subject.BSWrapper;

import static java.lang.Math.abs;

public class Model {

    private RuntimeConfiguration configuration;

    private ModulesContext mModulesContext;

    public Model(RuntimeConfiguration configuration) {
        this.configuration = configuration;
        mModulesContext = new ModulesContext(configuration);
        configuration.getLog().d("Model", "inited");
    }

    public BSWrapper<Content> getCurrentTrack() {
        return mModulesContext.getPlayerModule().getPlayerActor().getCurrent();
    }

    public void onEnded(Content content) {
        mModulesContext.getPlayerModule().getPlayerActor().getRef()
                .send(new PlayerActor.Ended(content));
    }

    public RuntimeConfiguration getConfiguration() {
        return configuration;
    }
}