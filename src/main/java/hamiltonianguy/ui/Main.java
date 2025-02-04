package hamiltonianguy.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import hamiltonianguy.HamiltonianGuy;



public class Main extends Application {

    private TextArea chatDisplay;
    private TextField userInput;
    private HamiltonianGuy chatbot;

    @Override
    public void start(Stage stage) {
        chatbot = new HamiltonianGuy();

        // 🔹 Chat display area
        chatDisplay = new TextArea();
        chatDisplay.setEditable(false);
        chatDisplay.setWrapText(true);
        chatDisplay.setPrefHeight(400);

        // 🔹 Input field
        userInput = new TextField();
        userInput.setPromptText("Type a message...");

        // 🔹 Send button
        Button sendButton = new Button("Send");
        sendButton.setOnAction(event -> handleUserInput());

        // 🔹 Layout: Input field + Button
        HBox inputArea = new HBox(10, userInput, sendButton);

        // 🔹 Main layout
        VBox layout = new VBox(10, chatDisplay, inputArea);
        layout.setStyle("-fx-padding: 10px;");

        // 🔹 Scene setup
        Scene scene = new Scene(layout, 500, 500);
        stage.setTitle("HamiltonianGuy Chatbot");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles user input and updates the chat display.
     */
    private void handleUserInput() {
        String input = userInput.getText().trim();
        if (!input.isEmpty()) {
            chatDisplay.appendText("You: " + input + "\n");
            chatDisplay.appendText("---------------------------------------" + "\n");
            String response = chatbot.getResponse(input);
            chatDisplay.appendText("HamiltonianGuy: " + "\n" + response + "\n");
            chatDisplay.appendText("---------------------------------------" + "\n");
            userInput.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
