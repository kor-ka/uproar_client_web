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

    private Map<Integer, Content> cache = new HashMap<Integer, Content>();

    private BSWrapper<Content> current = rxProvider.bs(Content.dummy());

    private BSWrapper<List<Content>> queueVM = rxProvider.bs(queue);

    private PublishSubjectWrapper<Content> actions = rxProvider.ps();

    private PublishSubjectWrapper<Collection<Integer>> boring = rxProvider.ps();

    private LinkedHashSet<Integer> latestPlayed= new LinkedHashSet<>();

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
            Content mContent = ((AddContent) message).mContent;
            log.d("Player", "on AddContent:" + mContent);


            boolean addThis = true;
            if (mContent instanceof UnknownContent) {
                log.d("Player", "ignore unknown");
                addThis = false;
            }

            if(addThis){
                int index = queue.size();

                // put actual content before boring
                if(!mContent.isBoring()){
                    for (int i = 0; i < queue.size(); i++) {
                        if(queue.get(i).isBoring()){
                            index = i;
                            break;
                        }
                    }
                }

                queue.add(index, mContent);
                cache.put(mContent.getOriginalId(),
                        mContent);

                // track played to exclude from boring later
                if(latestPlayed.contains(mContent.getOriginalId())){
                    latestPlayed.remove(mContent.getOriginalId());
                }
                latestPlayed.add(mContent.getOriginalId());
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

        if(queue.size() < 10){
            boring.onNext(latestPlayed);
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

    public PublishSubjectWrapper<Collection<Integer>> getBoring() {
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
