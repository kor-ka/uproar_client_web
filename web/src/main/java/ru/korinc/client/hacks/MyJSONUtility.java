package ru.korinc.client.hacks;

import com.google.gwt.core.client.JavaScriptObject;

public class MyJSONUtility {

    interface JSONHandler {

        public void handleJSON(JavaScriptObject obj);
    }

    private static native void makeJSONRequest(String url, JSONHandler handler) /*-{
       $wnd.jsonCallback = function(jsonObj)
       {
         @ru.korinc.client.hacks.MyJSONUtility::dispatchJSON(*)(jsonObj, handler);
       }

       // create SCRIPT tag, and set SRC attribute equal to JSON feed URL + callback function name
       var script = $wnd.document.createElement("script");
       script.setAttribute("src", url+"jsonCallback");
       script.setAttribute("type", "text/javascript");

       $wnd.document.getElementsByTagName("head")[0].appendChild(script);

   }-*/;

    public static void dispatchJSON(JavaScriptObject jsonObj, JSONHandler handler) {
        handler.handleJSON(jsonObj);
    }

}