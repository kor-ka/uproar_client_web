package ru.korinc.client.player;

/**
 * Created by gputintsev on 21.12.17.
 */

public class PlayerController implements Player {

    private EventListener onStop;

    public PlayerController(String tag) {
        init(tag);
    }

    private native void init(String tag)/*-{

        player = $wnd.document.createElement('audio');
        player.controls = true
        player.autoplay= true
        $wnd.document.getElementById("audio_player").appendChild(player);
        
        
        var isPlaying = false;
        var isWaiting = false;
        var pauseFromUser = false;

        function togglePlay() {
          if (isPlaying) {
            pauseFromUser = true;
            player.pause()
          } else {
            player.play();
          }
        };
        player.onplaying = function() {
          pauseFromUser = false;
          isPlaying = true;
          isWaiting = false;
        };

        player.onpause = function() {
          isPlaying = false;
          if(!pauseFromUser && !isWaiting &&  (typeof onStop != 'undefined')){
            onStop.@ru.korinc.client.player.PlayerController.EventListener::onEvent()();
          }
        };

        player.onwaiting = function() {
          isWaiting = true;
        };

//        player.stalled = function() {
//          isWaiting = true;
//        };
//
//        player.onloadstart = function() {
//          isWaiting = true;
//        };
//
//        player.onloadeddata = function() {
//          isWaiting = false;
//        };

        $wnd.document.getElementById("header").addEventListener("click", togglePlay);


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

        player.ontimeupdate = function() {

            if(player.duration > 0){
                progressListener.@ru.korinc.client.player.Player.ProgressListener::onProgress(Ljava/lang/Double;)(player.currentTime/player.duration);

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

    public native void onStop(EventListener onStopCallback)/*-{
        onStop = onStopCallback;
    }-*/;

    public interface EventListener {

        public void onEvent();
    }
}
