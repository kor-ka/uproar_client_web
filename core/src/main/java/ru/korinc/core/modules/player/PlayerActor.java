package ru.korinc.core.modules.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.korinc.runtime.rx.RxActor;
import ru.korinc.runtime.rx.subject.BSWrapper;
import ru.korinc.runtime.rx.subject.PublishSubjectWrapper;

import static ru.korinc.runtime.RuntimeConfiguration.log;
import static ru.korinc.runtime.RuntimeConfiguration.rxProvider;

/**
 * Created by gputintsev on 20.12.17.
 */

public class PlayerActor extends RxActor {

    private List<Content> queue = new ArrayList<>();

    private Set<Content> old = new HashSet<>();

    private BSWrapper<Content> current = rxProvider.bs(Content.dummy());

    private PublishSubjectWrapper<Content> actions = rxProvider.ps();

    private PublishSubjectWrapper<Object> boring = rxProvider.ps();

    public PlayerActor() {
        fireStart();
    }

    @Override
    protected void onStart() {
        playNext();
    }

    @Override
    protected void onMessage(Object message) {
        log.d("Player", message.toString());

        Content currentContent = current.getValue();
        if (message instanceof AddContent) {
            log.d("Player", "on AddContent:" + ((AddContent) message).mContent);

            if (((AddContent) message).mContent instanceof UnknownContent) {
                log.d("Player", "ignore unknown");
                return;
            }

            if (old.contains(((AddContent) message).mContent)) {
                log.d("Player", "old track - ignore");
                return;
            }
            queue.add(((AddContent) message).mContent);
            if (currentContent.isDummy()) {
                playNext();
            }
        } else if (message instanceof Promote) {
            if (!((Promote) message).id.equals(currentContent.getOriginalId())) {
                Content target = pickById(((Promote) message).id);
                if (target != null) {
                    target.setAction("promote");
                    queue.remove(target);
                    queue.set(0, target);
                }
            }
        } else if (message instanceof Skip) {
            Content target = pickById(((Skip) message).id);
            if (target != null) {
                target.setAction("skip");
                queue.remove(target);
            }
            if (currentContent.getOriginalId().equals(((Skip) message).id)) {
                playNext();
            }
        } else if (message instanceof Ended) {
            if (currentContent.getOriginalId().equals(((Ended) message).id.getOriginalId())) {
                playNext();
            }
        }
    }

    private void playNext() {
        log.d("Player", "playNext");
        if (queue.size() > 0) {
            current.onNext(queue.get(0));
            queue.remove(0);
        } else {
            current.onNext(Content.dummy());
            boring.onNext(new Object());
        }
    }


    public BSWrapper<Content> getCurrent() {
        return current;
    }

    public PublishSubjectWrapper<Content> getActions() {
        return actions;
    }

    public PublishSubjectWrapper<Object> getBoring() {
        return boring;
    }

    private Content pickById(String id) {
        Content target = null;
        for (Content c : queue) {
            if (c.getOriginalId().equals(id)) {
                target = c;
            }
        }

        return target;
    }


    public static class AddContent {

        private Content mContent;

        public AddContent(Content content) {
            mContent = content;
        }
    }

    public static class Promote {

        private String id;

        public Promote(String id) {
            this.id = id;
        }
    }

    public static class Skip {

        private String id;

        public Skip(String id) {
            this.id = id;
        }
    }

    public static class Ended {

        private Content id;

        public Ended(Content id) {
            this.id = id;
        }
    }


}
