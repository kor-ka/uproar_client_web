package ru.korinc.client.player;

/**
 * Created by gputintsev on 25.12.17.
 */

public class YtbController {

    public YtbController() {

        init();
    }

    private native void init()/*-{
        inited = false
    }-*/;

    public native void setStopListener(YtbStopListener listener)/*-{

        $wnd.ytb_player.addEventListener('onStateChange', 'on_ytb_stop')

        $wnd.on_ytb_stop = function(e){
        console.log(e)
            if(e.data == 0) {
                listener.@ru.korinc.client.player.YtbController.YtbStopListener::onStop()();
            }
        }


    }-*/;

    public native void play(String url)/*-{
        inited = true
        $wnd.ytb_player.loadVideoByUrl(url)
//        $wnd.ytb_player.playVideo()
    }-*/;

    public native void stop()/*-{
        if(inited){
            $wnd.ytb_player.stopVideo()
        }
    }-*/;

    public interface YtbStopListener {

        public void onStop();
    }
}
