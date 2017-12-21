package ru.korinc.runtime.interop;

/**
 * Created by gputintsev on 21.12.17.
 */

public class Mqtt {

    public native void init(String username, String password, MqttCallbacks callbacks)/*-{
        var client = $wnd.client;
        client.onConnectionLost = onConnectionLost;
        client.onMessageArrived = onMessageArrived;
        var options = {
            useSSL: true,
            userName: username,
            password: password,
            onSuccess:onConnect,
            onFailure:doFail
        }

        client.connect(options);


          function onConnect() {
            callbacks.@ru.korinc.runtime.interop.Mqtt.MqttCallbacks::onConnect()();
          }

          function doFail(e){
             callbacks.@ru.korinc.runtime.interop.Mqtt.MqttCallbacks::onError()();
          }

          function onConnectionLost(responseObject) {
            if (responseObject.errorCode !== 0) {
                callbacks.@ru.korinc.runtime.interop.Mqtt.MqttCallbacks::onConnectionLost()();
            }
          }

          function onMessageArrived(message) {
              callbacks.@ru.korinc.runtime.interop.Mqtt.MqttCallbacks::onMessage(Ljava/lang/String;)(message.payloadString);
          }
    }-*/;

    public interface MqttCallbacks {

        void onConnect();

        void onError();

        void onConnectionLost();

        void onMessage(String message);
    }
}
