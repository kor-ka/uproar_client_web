package ru.korinc.runtime.rx;

import ru.korinc.runtime.rx.subject.PublishSubjectWrapper;

import static ru.korinc.runtime.RuntimeConfiguration.rxProvider;

/**
 * Created by gputintsev on 23.03.17.
 */

public abstract class RxActor {

    private ActorRef ref = new ActorRef();

    public RxActor() {

        ref.getRef().observeOn(rxProvider.scheduler()).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {

                if (o instanceof OnStart) {
                    onStart();
                } else {
                    onMessage(o);
                }
            }
        });
    }

    //call this for executing onStart on Actor thread (e.g. you need to call thmth in constructor, but not on thread, where actor created)
    public void fireStart() {
        getRef().send(new OnStart());
    }

    protected void onStart() {

    }

    protected abstract void onMessage(Object message);

    public ActorRef getRef() {
        return ref;
    }

    public static class ActorRef {

        private PublishSubjectWrapper<Object> ref;

        public ActorRef() {
            this.ref = rxProvider.ps();
        }

        public PublishSubjectWrapper<Object> getRef() {
            return ref;
        }

        public void send(Object message) {
            ref.onNext(message);
        }
    }

    private static class OnStart {

    }
}
