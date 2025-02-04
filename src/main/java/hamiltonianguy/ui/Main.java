package hamiltonianguy.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello! I'm HamiltonianGuy. What can I do for you?");
        StackPane layout = new StackPane(label);
        Scene scene = new Scene(layout, 400, 200);

        stage.setTitle("HamiltonianGuy");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
