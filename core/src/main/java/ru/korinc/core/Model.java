package ru.korinc.core;

import ru.korinc.core.modules.ModulesContext;
import ru.korinc.core.modules.player.Content;
import ru.korinc.core.modules.player.PlayerActor;
import ru.korinc.runtime.RuntimeConfiguration;
import ru.korinc.runtime.rx.subject.BSWrapper;
import ru.korinc.runtime.rx.subject.PublishSubjectWrapper;

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

    public PublishSubjectWrapper<Content> getActions() {
        return mModulesContext.getPlayerModule().getPlayerActor().getActions();
    }

    public PublishSubjectWrapper<Object> getBoring() {
        return mModulesContext.getPlayerModule().getPlayerActor().getBoring();
    }



    public void onEnded(Content content) {
        mModulesContext.getPlayerModule().getPlayerActor().getRef()
                .send(new PlayerActor.Ended(content));
    }

    public RuntimeConfiguration getConfiguration() {
        return configuration;
    }

    public void addContent(Content content) {
        mModulesContext.getPlayerModule().getPlayerActor().getRef()
                .send(new PlayerActor.AddContent(content));
    }

    public void promote(String id) {
        mModulesContext.getPlayerModule().getPlayerActor().getRef()
                .send(new PlayerActor.Promote(id));
    }

    public void skip(String id) {
        mModulesContext.getPlayerModule().getPlayerActor().getRef().send(new PlayerActor.Skip(id));
    }
}