package ru.korinc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import ru.korinc.core.AppCore;
import ru.korinc.core.Model;
import ru.korinc.runtime.interop.web3.Eth;

import static ru.korinc.core.utils.Utils.apply;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Omdb implements EntryPoint {

    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    private final Model model = AppCore.sharedCore().getModel();

    private int generation = -1;

    private RootPanel mRetryContainer;

    private Button mRetry;


    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        mRetry = new Button("Retry");
        final TextBox balanceField = new TextBox();
        balanceField.setEnabled(false);
        // We can add style names to widgets
        mRetry.addStyleName("sendButton");


        final Label errorLabel = new Label();



        // Add the balanceField and sendButton to the RootPanel
        // Use RootPanel.get() to get the entire body element
        RootPanel.get("nameFieldContainer").add(balanceField);
        mRetryContainer = RootPanel.get("retryButtonContainer");
        RootPanel.get("errorLabelContainer").add(errorLabel);


        // Create a handler for the sendButton and balanceField
        class MyHandler implements ClickHandler, KeyUpHandler {

            /**
             * Fired when the user clicks on the sendButton.
             */
            public void onClick(ClickEvent event) {
                retry();
            }

            /**
             * Fired when the user types in the balanceField.
             */
            public void onKeyUp(KeyUpEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    retry();
                }
            }

            /**
             * Send the name from the balanceField to the server and wait for a response.
             */
            private void retry() {

                checkBalance(balanceField);
            }
        }

        checkBalance(balanceField);



        // Add a handler to send the name to the server
        MyHandler handler = new MyHandler();
        mRetry.addClickHandler(handler);
        balanceField.addKeyUpHandler(handler);





    }

    private void checkBalance(TextBox nameField) {
        mRetryContainer.clear();

        if(new Eth().loggedIn()){
            new Eth().getBalance(balance -> nameField.setText(balance + ""));
        }else{
            nameField.setText("login first");
            mRetryContainer.add(mRetry);
        }


    }
}
