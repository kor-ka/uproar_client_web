package ru.korinc.core.modules.player;

import java.util.*;

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

    private Map<String, Content> cache = new HashMap<String, Content>();

    private BSWrapper<Content> current = rxProvider.bs(Content.dummy());

    private BSWrapper<List<Content>> queueVM = rxProvider.bs(queue);

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
            
            if(!((AddContent) message).mContent.isBoring()){
                for (Iterator<Content> iter = queue.listIterator(); iter.hasNext(); ) {
                    Content c = iter.next();
                    if (c.isBoring()) {
                        iter.remove();
                    }
                }
            }
            
            
            boolean addThis = true;
            if (((AddContent) message).mContent instanceof UnknownContent) {
                log.d("Player", "ignore unknown");
                addThis = false;
            }

            if (queue.contains(((AddContent) message).mContent) || currentContent.equals(((AddContent) message).mContent)) {
                log.d("Player", "old track - ignore");
                addThis = false;
                // old track from boring - request one more
                if(((AddContent) message).mContent.isBoring() && queue.size() == 0){
                    boring.onNext(new Object());
                }
            }

            // do not add boring if have smth in queue
           if(((AddContent) message).mContent.isBoring() && queue.size() > 0){
               addThis = false;
           }

            if(addThis){
                queue.add(((AddContent) message).mContent);
                cache.put(((AddContent) message).mContent.getOriginalId(),
                        ((AddContent) message).mContent);
                notifyQueueUpdated();
            }
            if (currentContent.isDummy()) {
                playNext();
            }
        } else if (message instanceof Promote) {
            if (!((Promote) message).id.equals(currentContent.getOriginalId())) {
                Content target = pickById(((Promote) message).id);
                if (target != null) {
                    target.setAction("promote");
                    queue.remove(target);
                    queue.add(0, target);
                    notifyQueueUpdated();
                }
            }
        } else if (message instanceof Skip) {
            Content target = pickById(((Skip) message).id);
            if (target != null) {
                target.setAction("skip");
                queue.remove(target);
                notifyQueueUpdated();
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

    private void notifyQueueUpdated() {
        queueVM.onNext(new ArrayList<>(queue));
    }

    private void playNext() {
        log.d("Player", "playNext");
        if (queue.size() > 0) {
            current.onNext(queue.get(0));
            queue.remove(0);
            notifyQueueUpdated();
        }

        if(queue.size() == 0){
            boring.onNext(new Object());
        }
    }

    public BSWrapper<List<Content>> getQueueVM() {
        return queueVM;
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
        return cache.get(id);
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
