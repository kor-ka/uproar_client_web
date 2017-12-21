package ru.korinc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import ru.korinc.client.player.PlayerController;
import ru.korinc.core.AppCore;
import ru.korinc.core.Model;
import ru.korinc.core.modules.player.Content;
import ru.korinc.runtime.interop.Mqtt;
import ru.korinc.runtime.logging.LogProvider;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Omdb implements EntryPoint {


    private final Model model = AppCore.sharedCore().getModel();


    private RootPanel mRetryContainer;

    private Content currentContent = Content.dummy();

    private LogProvider log = model.getConfiguration().getLog();


    public void onModuleLoad() {

        String token = com.google.gwt.user.client.Window.Location.getParameter("token");

        Mqtt mqtt = new Mqtt();

        String[] split = token.split("-");
        String username = split[0] + "-" + split[1];

        log.d("MQTT login", username + " " + token);

        mqtt.init(username, token, new Mqtt.MqttCallbacks() {
            @Override
            public void onConnect() {
                log.d("MQTT", "onConnect");
            }

            @Override
            public void onError() {
                log.d("MQTT", "onError");

            }

            @Override
            public void onConnectionLost() {
                log.d("MQTT", "onConnectionLost");

            }

            @Override
            public void onMessage(String message) {
                log.d("MQTT", "onMessage: " + message);
            }
        });

        PlayerController player = new PlayerController("player");

        model.getCurrentTrack().observeOnMain().subscribe(content -> {
            if (!currentContent.equals(content)) {
                player.pause();
                player.setSrc(content.getSrc());
                player.play();
                currentContent = content;
            }
        });

        player.addEventListener("ended", () -> {
            //TODO resolve somehow exact track ended
            model.onEnded(currentContent);
        });


    }
}
