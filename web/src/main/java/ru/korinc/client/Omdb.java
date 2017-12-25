package ru.korinc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.ArrayList;

import ru.korinc.client.player.PlayerController;
import ru.korinc.client.player.YtbController;
import ru.korinc.core.AppCore;
import ru.korinc.core.Model;
import ru.korinc.core.modules.player.Content;
import ru.korinc.core.modules.player.Mp3Content;
import ru.korinc.core.modules.player.YoutubeContent;
import ru.korinc.runtime.interop.Mqtt;
import ru.korinc.runtime.json.JsonObjectWrapper;
import ru.korinc.runtime.json.JsonProvider;
import ru.korinc.runtime.logging.LogProvider;

import static ru.korinc.runtime.RuntimeConfiguration.json;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Omdb implements EntryPoint {


    private final Model model = AppCore.sharedCore().getModel();


    private RootPanel mRetryContainer;

    private Content currentContent = Content.dummy();

    private LogProvider log = model.getConfiguration().getLog();

    private Mqtt mqtt = new Mqtt();

    private String token;

    private boolean connected = false;

    private ArrayList<MqttMsg> pubQueue = new ArrayList<>();

    private RootPanel headerContainer;


    public void onModuleLoad() {

        headerContainer =  mRetryContainer = RootPanel.get("header");

        //
        //  Player
        //
        PlayerController player = new PlayerController("player");

        YtbController ytbController = new YtbController();

        model.getCurrentTrack().observeOnMain().subscribe(content -> {
            if (!currentContent.equals(content)) {
                player.pause();
                ytbController.stop();
                log.d("front", "on content: " + content.toString());
                if (content instanceof Mp3Content) {
                    player.setSrc(content.getSrc());
                    player.play();
                } else if (content instanceof YoutubeContent) {
                    log.d("front", "ytb url: " + content.getSrc());
                    ytbController.play(content.getSrc());
                }
                if (!content.isDummy()) {
                    headerContainer.clear();
                    headerContainer.add(new HTMLPanel("h1", content.getTitle()));

                    publish("update_track_status",
                            content.getBag().putString("message", "playing"));
                }

                currentContent = content;
            }
        });

        model.getActions().subscribe(content -> {
            if (content.getAction() != null) {
                publish("update_track_status",
                        content.getBag().putString("message", content.getAction()));
            }
        });

        model.getBoring().subscribe(b -> {
            publish("boring", json.getJson("{}"));
        });

        player.addEventListener("ended", this::onStop);
        ytbController.setStopListener(this::onStop);

        //
        //  MQTT
        //
        token = com.google.gwt.user.client.Window.Location.getParameter("token");


        String[] split = token.split("-");
        String username = split[0] + "-" + split[1];

        log.d("MQTT login", username + " " + token);

        mqtt.init(username, token, new Mqtt.MqttCallbacks() {
            @Override
            public void onConnect() {
                log.d("MQTT", "onConnect");
                mqtt.subscribe("device_in_" + token);

                mqtt.send("registry", token);

                connected = true;

                for (MqttMsg m : pubQueue) {
                    publish(m.topik, m.msg);
                }

                pubQueue.clear();

            }

            @Override
            public void onError() {
                log.d("MQTT", "onError");

            }

            @Override
            public void onConnectionLost() {
                log.d("MQTT", "onConnectionLost");
                connected = false;
            }

            @Override
            public void onMessage(String message) {
                log.d("MQTT", "onMessage: " + message);
                JsonObjectWrapper msg = json.getJson(message);
                if (msg.getString("update").equals("add_content")) {
                    String additionalId = msg.getString("additional_id");
                    if(additionalId == null || additionalId.equals(mqtt.getClientId())){
                        Content data = Content.fromJson(msg.getJsonObject("data"));
                        model.addContent(data);
                        publish("update_track_status", data.getBag().putString("message", "queue"));
                    }
                } else if (msg.getString("update").equals("promote")) {
                    model.promote(Integer.toString(msg.getInteger("data", -1)));
                } else if (msg.getString("update").equals("skip")) {
                    model.skip(Integer.toString(msg.getInteger("data", -1)));
                }
            }
        });


    }

    private void onStop() {
        model.onEnded(currentContent);
        publish("update_track_status", currentContent.getBag().putString("message", "done"));
    }

    private void publish(String update, JsonObjectWrapper data) {
        JsonObjectWrapper msg = json.getJson("{}");
        msg.putString("update", update);
        msg.putString("token", token);
        msg.putObject("data", data);
        if (connected) {
            msg.putString("additional_id", mqtt.getClientId());
            mqtt.send("device_out", msg.toJsonString());
        } else {
            pubQueue.add(new MqttMsg(update, data));
        }
    }

    private static class MqttMsg {

        private String topik;

        private JsonObjectWrapper msg;

        public MqttMsg(String topik, JsonObjectWrapper msg) {
            this.topik = topik;
            this.msg = msg;
        }
    }

}
