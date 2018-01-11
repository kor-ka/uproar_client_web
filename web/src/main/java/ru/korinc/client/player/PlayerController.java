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
        player.autoplay= true
        $wnd.document.getElementById("audio_player").appendChild(player);


    }-*/;

    public native void play(ErrorListener errorListener, ProgressListener progressListener)/*-{
        playPromise = player.play()

        // In browsers that don’t yet support this functionality,
        // playPromise won’t be defined.
        if (playPromise !== undefined) {
          playPromise.then(success, failure);
        }

        function success(){

        }

        function failure(err){
             errorListener.@ru.korinc.client.player.Player.ErrorListener::onError()();
        }

        player.onprogress = function() {
            if(player.currentTime > 0){
                progressListener.@ru.korinc.client.player.Player.ProgressListener::onProgress(Ljava/lang/Double;)(player.duration/player.currentTime);

            }else{
                progressListener.@ru.korinc.client.player.Player.ProgressListener::onProgress(Ljava/lang/Double;)(0);
            }

        };

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
