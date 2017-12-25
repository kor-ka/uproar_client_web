package ru.korinc.core.modules.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.korinc.runtime.rx.RxActor;
import ru.korinc.runtime.rx.subject.BSWrapper;

import static ru.korinc.runtime.RuntimeConfiguration.log;
import static ru.korinc.runtime.RuntimeConfiguration.rxProvider;

/**
 * Created by gputintsev on 20.12.17.
 */

public class PlayerActor extends RxActor {

    private List<Content> queue = new ArrayList<>();

    private Set<Content> old = new HashSet<>();

    private BSWrapper<Content> current = rxProvider.bs(Content.dummy());


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
                    queue.remove(target);
                    queue.set(0, target);
                }
            }
        } else if (message instanceof Skip) {
            Content target = pickById(((Skip) message).id);
            if (target != null) {
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
            current.onNext(queue.get(queue.size() - 1));
            queue.remove(queue.size() - 1);
        } else {
            current.onNext(Content.dummy());
        }
    }


    public BSWrapper<Content> getCurrent() {
        return current;
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
