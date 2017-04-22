package ru.korinc.core.modules;

import ru.korinc.runtime.rx.RxProvider;

/**
 * Created by gputintsev on 21.03.17.
 */

public abstract class ModuleBase {

    protected ModulesContext mContext;

    protected RxProvider mRxProvider;

    public ModuleBase(ModulesContext context) {
        mContext = context;
        mRxProvider = getContext().getRuntimeConfiguration().getRxProvider();
    }

    public ModulesContext getContext() {
        return mContext;
    }

    public abstract void run();
}
