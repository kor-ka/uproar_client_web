package ru.korinc.client.player;

/**
 * Created by gputintsev on 25.12.17.
 */

public class YtbController implements Player {

    public YtbController() {

        init();
    }

    private native void init()/*-{
        inited = false

        height = $doc.body.scrollHeight
    }-*/;

    public native void setStopListener(YtbStopListener listener)/*-{

        $wnd.ytb_player.addEventListener('onStateChange', 'on_ytb_stop')
        $wnd.ytb_player.addEventListener('onError', 'on_ytb_error')

        $wnd.on_ytb_stop = function(e){
        console.log(e)
            if(e.data == 0) {
                $wnd.document.getElementById("ytb_container").style.height= '0px'
                $wnd.document.getElementById("ytb_player").style.height= '0px'
                listener.@ru.korinc.client.player.YtbController.YtbStopListener::onStop()();

            }
        }

        $wnd.on_ytb_error = function(e){
        console.log(e)
            if(e.data == 101 || e.data == 150) {
                $wnd.document.getElementById("ytb_container").style.height= '0px'
                $wnd.document.getElementById("ytb_player").style.height= '0px'
                listener.@ru.korinc.client.player.YtbController.YtbStopListener::onStop()();

            }
        }


    }-*/;

    public native void play(String url)/*-{
        inited = true
        $wnd.ytb_player.loadVideoByUrl(url)

        $wnd.document.getElementById("ytb_container").style.height= height + 'px'
        $wnd.document.getElementById("ytb_player").style.height= height + 'px'

//        $wnd.ytb_player.playVideo()
    }-*/;

    public native void stop()/*-{
        if(inited){
            $wnd.document.getElementById("ytb_container").style.height= '0px'
            $wnd.document.getElementById("ytb_player").style.height= '0px'
            $wnd.ytb_player.stopVideo()
        }
    }-*/;

    @Override
    public native void play(ErrorListener errorListener, ProgressListener progressListener)/*-{
     $wnd.ytb_player.playVideo()
    }-*/;


    public interface YtbStopListener {

        public void onStop();
    }
}
