package ru.korinc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.google.gwt.user.client.ui.Widget;
import ru.korinc.client.player.Player;
import ru.korinc.client.player.PlayerController;
import ru.korinc.client.player.YtbController;
import ru.korinc.client.util.ContentDiffCallback;
import ru.korinc.client.util.DiffUtil;
import ru.korinc.client.util.ListUpdateCallback;
import ru.korinc.core.AppCore;
import ru.korinc.core.Model;
import ru.korinc.core.modules.player.Content;
import ru.korinc.core.modules.player.Mp3Content;
import ru.korinc.core.modules.player.YoutubeContent;
import ru.korinc.runtime.RuntimeConfiguration;
import ru.korinc.runtime.interop.Mqtt;
import ru.korinc.runtime.json.JsonArrayWrapper;
import ru.korinc.runtime.json.JsonObjectWrapper;
import ru.korinc.runtime.logging.LogProvider;

import static ru.korinc.runtime.RuntimeConfiguration.json;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Omdb implements EntryPoint {


    private final Model model = AppCore.sharedCore().getModel();


    private Content currentContent = Content.dummy();

    private LogProvider log = model.getConfiguration().getLog();

    private Mqtt mqtt = new Mqtt();

    private String token;

    private String silentStr;

    private Boolean silent = false;

    private String startWithStr;

    private Integer startWith;

    private String chatUsername;

    private boolean connected = false;

    private ArrayList<MqttMsg> pubQueue = new ArrayList<>();

    private RootPanel headerContainer;

    private RootPanel queueContainer;

    private RootPanel line;

    private RootPanel playContainer;

    private Player currentplayer;

    private Widget context;
    private Widget contextImage;
    private Widget contextTitle;
    private Widget contextOwner;
    private Widget contextId;

    private HTMLPanel nextTitle = new HTMLPanel("h2", "next:");

    private HTMLPanel historyTitle = new HTMLPanel("h2", "history:");

    private HashMap<Integer, HTMLPanel> msgCache = new HashMap<>();


    public void onModuleLoad() {

        token = com.google.gwt.user.client.Window.Location.getParameter("token");
        silentStr = com.google.gwt.user.client.Window.Location.getParameter("silent");
        silent = "true".equals(silentStr);
        startWithStr = com.google.gwt.user.client.Window.Location.getParameter("start_with");
        try {
            startWith = Integer.parseInt(startWithStr);
        } catch (Exception ignore) {
        }

        context = RootPanel.get("context_container");
        contextImage = RootPanel.get("context_image");
        contextTitle = RootPanel.get("context_title");
        contextOwner = RootPanel.get("context_owner");
        contextId = RootPanel.get("context_id");

        //initial setting
        nextTitle.asWidget().getElement().getStyle().setProperty("font-size", "32px");
        historyTitle.asWidget().getElement().getStyle().setProperty("font-size", "32px");


        headerContainer = RootPanel.get("header");
        playContainer = RootPanel.get("play_container");
        playContainer.setHeight("0px");

        queueContainer = RootPanel.get("list");
        line = RootPanel.get("line");

        updateHeader("Connecting...");

        //
        //  Player
        //
        PlayerController player = new PlayerController("player");

        YtbController ytbController = new YtbController();

        currentplayer = null;

        // actual content
        model.getCurrentTrack().observeOnMain().subscribe(content -> {
            log.d("front", "on content: " + content.toString());

            if (!currentContent.equals(content)) {
                player.pause();
                ytbController.stop();
                currentplayer = null;

                line.setHeight("0px");

                if (content instanceof Mp3Content) {
                    line.setHeight("2px");
                    player.setSrc(content.getSrc());
                    player.play(this::addPlayButton, progress -> {
                        line.setWidth(progress * 100 + "%");
                    });

                    currentplayer = player;
                    show_context(true);
                } else if (content instanceof YoutubeContent) {
                    log.d("front", "ytb url: " + content.getSrc());
                    ytbController.play(content.getSrc());

                    currentplayer = ytbController;
                    show_context(false);

                }
                if (!content.isDummy()) {
                    updateHeader(content.getTitle());

                    String margin = headerContainer.getWidget(0).getOffsetHeight() / 2 + 40 + context.asWidget().getOffsetHeight() + "px";
                    line.asWidget().getElement().getStyle().setProperty("margin-top", margin);
                    line.asWidget().getElement().getStyle().setProperty("margin-bottom", margin);

                    publish("update_track_status",
                            content.getBag().putString("message", "playing"));
                }

                if (content.getOwner() != null && !content.getOwner().equals(contextTitle.asWidget().getElement().getInnerText())) {
                    contextOwner.getElement().setInnerText(content.getOwner() != null ? (" : " + content.getOwner()) : "");
                }

                currentContent = content;
            }
        });

        ArrayList<Content> old = new ArrayList<>();


        // update queue
        model.getQueue().observeOnMain().subscribe(queue -> {

            HashSet<Integer> msgs = new HashSet<>();
            for (Content c : queue) {
                msgs.add(c.getOriginalId());
            }

            DiffUtil.calculateDiff(new ContentDiffCallback(old, queue))
                    .dispatchUpdatesTo(new ListUpdateCallback() {
                        @Override
                        public void onInserted(int position, int count) {

                            for (int i = position; i < position + count; i++) {

                                if (chatUsername == null) {
                                    queueContainer
                                            .add(new HTMLPanel("h2", queue.get(i).getTitle()));
                                    if (queue.get(i).getOwner() != null) {
                                        HTMLPanel owner = new HTMLPanel("text",
                                                queue.get(i).getOwner());
                                        owner.getElement().setAttribute("class", "owner");
                                        queueContainer.add(owner);
                                    }
                                } else {
                                    Integer originalId = queue.get(i).getOriginalId();
                                    HTMLPanel div = msgCache.get(originalId);
                                    if (div == null) {
                                        log.d("post", "new post div");
                                        div = new HTMLPanel("div", "");

                                        div.asWidget().getElement().getStyle()
                                                .setProperty("padding-top",
                                                        queue.size() > 0 ? "30px" : "0px");

                                        ScriptElement sce = Document.get().createScriptElement();
                                        sce.setType("text/javascript");
                    /*
                    <script async src="https://telegram.org/js/telegram-widget.js?4" data-telegram-post="radio_persimmon/55" data-width="100%"></script>
                     */
                                        sce.setSrc("https://telegram.org/js/telegram-widget.js?4");
                                        sce.setAttribute("data-telegram-post",
                                                chatUsername + "/" + originalId);
                                        sce.setAttribute("data-width", "100%");
                                        div.getElement().appendChild(sce);
                                        msgCache.put(originalId, div);
                                    }

                                    queueContainer.insert(div, i);

                                }
                            }
                        }

                        @Override
                        public void onRemoved(int position, int count) {
                            for (int i = position; i < position + count; i++) {
                                queueContainer.remove(i);
                            }
                        }

                        @Override
                        public void onMoved(int fromPosition, int toPosition) {
                            HTMLPanel toMove = msgCache.get(old.get(fromPosition).getOriginalId());
                            log.d("onMOveDubug", "from:" + fromPosition + " to:" + toPosition);
                            log.d("onMOveDubug", "obj:" + toMove);
                            queueContainer.remove(toMove);
                            queueContainer.insert(toMove, toPosition);
                        }

                        @Override
                        public void onChanged(int position, int count, Object payload) {

                        }
                    });

            old.clear();
            old.addAll(queue);


            queueContainer.asWidget().getElement().getStyle()
                    .setProperty("padding-bottom", queue.size() > 0 ? "30px" : "0px");


            HashSet<Integer> toRemove = new HashSet<>();
            for (Integer key : msgCache.keySet()) {
                if (!msgs.contains(key)) {
                    toRemove.add(key);
                }
            }
            for (Integer key : toRemove) {
                msgCache.remove(key);
            }
        });

        // update status
        model.getActions().subscribe(content -> {
            if (!silent && content.getAction() != null) {
                publish("update_track_status",
                        content.getBag().putString("message", content.getAction()));
            }
        });

        // notify boring
        model.getBoring().subscribe(b -> {

            ArrayList<Integer> l = new ArrayList<>(b);

            String s = "{ \"exclude\":" + l.toString() + "}";
            JsonObjectWrapper json = RuntimeConfiguration.json.getJson(s);

            publish("boring", json);
        });

        player.addEventListener("ended", this::onStop);
        player.onStop(this::onStop);
        ytbController.setStopListener(this::onStop);

        //
        //  MQTT
        //

        mqtt.init("web", "web", new Mqtt.MqttCallbacks() {
            @Override
            public void onConnect() {
                log.d("MQTT", "onConnect");
                mqtt.subscribe("device_in_" + token);
                mqtt.subscribe("device_in_" + token + "_" + mqtt.getClientId());

                JsonObjectWrapper json = RuntimeConfiguration.json.getJson("{}");
                json.putString("token", token);
                json.putString("additional_id", mqtt.getClientId());
                if (startWith != null) {
                    json.putInt("start_with", startWith);
                }

                mqtt.send("registry", json.toJsonString());

                connected = true;

                for (MqttMsg m : pubQueue) {
                    publish(m.topik, m.msg);
                }

                pubQueue.clear();
            }

            @Override
            public void onError() {
                log.d("MQTT", "onError");
                connected = false;
                mqtt.connect();
            }

            @Override
            public void onConnectionLost() {
                log.d("MQTT", "onConnectionLost");
                connected = false;
                mqtt.connect();

            }

            @Override
            public void onMessage(String message) {
                log.d("MQTT", "onMessage: " + message);
                JsonObjectWrapper msg = json.getJson(message);
                if (msg.getString("update").equals("add_content")) {
                    String additionalId = msg.getJsonObject("data").getString("additional_id");
                    log.d("addID", additionalId);
                    Content data = Content.fromJson(msg.getJsonObject("data"));
                    // boring sent via add_content for backward devices capability
                    if (!data.isBoring()) {
                        model.addContent(data);
                        publish("update_track_status", data.getBag().putString("message", "queue"));
                    }
                } else if (msg.getString("update").equals("boring_list")) {
                    JsonArrayWrapper array = msg.getJsonObject("data").getJsonArray("boring_list");
                    for (int i = 0; i < array.length(); i++) {
                        JsonObjectWrapper json = array.getJsonObjectWrapper(i);
                        Content data = Content.fromJson(json);
                        model.addContent(data);
                        publish("update_track_status", data.getBag().putString("message", "queue"));
                    }
                    model.readyForBoring();
                } else if (msg.getString("update").equals("promote")) {
                    model.promote(Integer.toString(msg.getInteger("data", -1)));
                } else if (msg.getString("update").equals("skip")) {
                    model.skip(Integer.toString(msg.getInteger("data", -1)));
                } else if (msg.getString("update").equals("init")) {
                    JsonObjectWrapper contextData = msg.getJsonObject("data").getJsonObject("context");

                    show_context(true);

                    contextTitle.getElement().setInnerText(contextData.getString("title"));
                    String clientId = mqtt.getClientId();
                    contextId.getElement().setInnerText(clientId.substring(clientId.length() - 5, clientId.length()));
                    String photo = contextData.getString("photo");
                    if (photo != null) {
                        contextImage.getElement().setAttribute("src", photo);
                    }
                    contextImage.getElement().getStyle().setProperty("width", photo!=null ? "64px" : "0px");

                    chatUsername = contextData.getString("username", null);
                }
            }
        });


    }

    private void show_context(boolean show) {
        context.getElement().getStyle().setProperty("height", show ? "auto" : "0px");
        contextImage.getElement().getStyle().setProperty("height", show ? "64px" : "0px");
        contextTitle.getElement().getStyle().setProperty("height", show ? "auto" : "0px");
        contextOwner.getElement().getStyle().setProperty("height", show ? "auto" : "0px");
        contextId.getElement().getStyle().setProperty("height", show ? "auto" : "0px");
    }

    private void updateHeader(String text) {
        headerContainer.clear();
        headerContainer.add(new HTMLPanel("h1", text));
        Window.setTitle(text);
    }

    private void addPlayButton() {
        Image forcePlay = new Image("play-button.svg");
        playContainer.add(forcePlay);
        playContainer.setHeight("200px");

        forcePlay.addClickHandler(event -> {
            if (currentplayer != null) {
                currentplayer.play(() -> {
                    model.onEnded(currentContent);
                }, p -> {
                    line.setWidth(p * 100 + "%");
                });
                playContainer.clear();
                playContainer.setHeight("0px");
            }
        });
    }

    private void onStop() {
        publish("update_track_status", currentContent.getBag().putString("message", "done"));
        model.onEnded(currentContent);
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
