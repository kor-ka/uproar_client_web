package ru.korinc.core.modules;

import ru.korinc.core.modules.player.PlayerActor;

/**
 * Created by gputintsev on 20.12.17.
 */

public class PlayerModule extends ModuleBase {

    private PlayerActor mPlayerActor = new PlayerActor();

    public PlayerModule(ModulesContext context) {
        super(context);
    }

    @Override
    public void run() {

    }

    public PlayerActor getPlayerActor() {
        return mPlayerActor;
    }
}
