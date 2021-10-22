package world.homans.blackjack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BlackjackApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BlackjackApplication.class.getResource("playroom-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 540);
        stage.setTitle("Blackjack Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
