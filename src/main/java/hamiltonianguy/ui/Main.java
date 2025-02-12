package hamiltonianguy.ui;

import hamiltonianguy.HamiltonianGuy;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application {

    private VBox chatContainer;
    private TextField userInput;
    private HamiltonianGuy chatbot;

    @Override
    public void start(Stage stage) {
        chatbot = new HamiltonianGuy();

        // 🔹 Chat container (VBox for messages)
        chatContainer = new VBox(10);
        chatContainer.setPadding(new Insets(10));
        chatContainer.setStyle("-fx-background-color: #f5f5f5;");
        ScrollPane scrollPane = new ScrollPane(chatContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        // 🔹 Input field and send button
        userInput = new TextField();
        userInput.setPromptText("Type a message...");
        Button sendButton = new Button("Send");
        sendButton.setOnAction(event -> handleUserInput());

        HBox inputArea = new HBox(10, userInput, sendButton);
        inputArea.setPadding(new Insets(10));
        inputArea.setAlignment(Pos.CENTER);

        // 🔹 Main layout
        VBox layout = new VBox(10, scrollPane, inputArea);
        Scene scene = new Scene(layout, 500, 500);
        stage.setTitle("HamiltonianGuy Chatbot");
        stage.setScene(scene);
        stage.show();

        // ✅ Show welcome message when starting the chat
        showWelcomeMessage();
    }

    /**
     * Handles user input and updates the chat display.
     */
    private void handleUserInput() {
        String input = userInput.getText().trim();
        if (!input.isEmpty()) {
            addMessage(input, true);
            String response = chatbot.getResponse(input);
            addMessage(response, false);
            userInput.clear();
        }
    }

    /**
     * Adds a message to the chat display, aligning based on sender.
     *
     * @param text The message text.
     * @param isUser If true, aligns right (user message). Otherwise, aligns left (bot response).
     */
    private void addMessage(String text, boolean isUser) {
        Text messageText = new Text(text);
        TextFlow textFlow = new TextFlow(messageText);
        textFlow.setPadding(new Insets(10));
        textFlow.setStyle("-fx-background-color: " + (isUser ? "#A3D4FF" : "#FFFFFF") +
                "; -fx-background-radius: 10px;");

        HBox messageContainer = new HBox(textFlow);
        messageContainer.setPadding(new Insets(5));

        if (isUser) {
            messageContainer.setAlignment(Pos.CENTER_RIGHT);
        } else {
            messageContainer.setAlignment(Pos.CENTER_LEFT);
        }

        chatContainer.getChildren().add(messageContainer);
    }

    /**
     * Displays a welcome message with a logo.
     */
    private void showWelcomeMessage() {
        Image logo = new Image(getClass().getResourceAsStream("/images/logo.jpg"));
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(80);
        logoView.setFitHeight(80);

        Label welcomeLabel = new Label("Hello! I'm HamiltonianGuy.\nHow can I assist you today?");
        welcomeLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        VBox welcomeBox = new VBox(10, logoView, welcomeLabel);
        welcomeBox.setAlignment(Pos.CENTER);
        welcomeBox.setPadding(new Insets(10));

        chatContainer.getChildren().add(welcomeBox);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
