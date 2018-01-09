package ru.korinc.client.player;

/**
 * Created by gputintsev on 21.12.17.
 */

public class PlayerController implements Player {

    public PlayerController(String tag) {
        init(tag);
    }

    private native void init(String tag)/*-{

        player = $wnd.document.createElement('audio');
        player.controls = true
        $wnd.document.getElementById("audio_player").appendChild(player);


    }-*/;

    public native void play()/*-{
        player.play()

    }-*/;

    @Override
    public void stop() {
        pause();
    }

    public native void pause()/*-{
        player.pause()
    }-*/;


    public native void setSrc(String src)/*-{
        player.src = src
    }-*/;

    public native void addEventListener(String event, EventListener listener)/*-{
        player.addEventListener(event, function() {
            listener.@ru.korinc.client.player.PlayerController.EventListener::onEvent()();
        }, true);
    }-*/;

    public interface EventListener {

        public void onEvent();
    }
}
