package ru.korinc.runtime.interop;

/**
 * Created by gputintsev on 21.12.17.
 */

public class Mqtt {

    public native void init(String username, String password, MqttCallbacks callbacks)/*-{
        $wnd.client.client_id = username + parseInt(Math.random() * 100, 10)
        $wnd.client.onConnectionLost = onConnectionLost;
        $wnd.client.onMessageArrived = onMessageArrived;
        var options = {
            useSSL: true,
            userName: username,
            password: password,
            onSuccess:onConnect,
            onFailure:doFail
        }

        $wnd.client.connect(options);


          function onConnect() {
            callbacks.@ru.korinc.runtime.interop.Mqtt.MqttCallbacks::onConnect()();
          }

          function doFail(e){
             callbacks.@ru.korinc.runtime.interop.Mqtt.MqttCallbacks::onError()();
          }

          function onConnectionLost(responseObject) {
            if (responseObject.errorCode !== 0) {
                console.log("onConnectionLost:"+responseObject.errorMessage)
                callbacks.@ru.korinc.runtime.interop.Mqtt.MqttCallbacks::onConnectionLost()();
            }
          }

          function onMessageArrived(message) {
              callbacks.@ru.korinc.runtime.interop.Mqtt.MqttCallbacks::onMessage(Ljava/lang/String;)(message.payloadString);
          }
    }-*/;

    public native void subscribe(String channel)/*-{
      $wnd.client.subscribe(channel)
    }-*/;

    public native void send(String channel, String message)/*-{
      message = new $wnd.Paho.MQTT.Message(message)
      message.destinationName = channel
      $wnd.client.send(message)
    }-*/;

    public interface MqttCallbacks {

        void onConnect();

        void onError();

        void onConnectionLost();

        void onMessage(String message);
    }
}
