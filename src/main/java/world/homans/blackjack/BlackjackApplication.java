package world.homans.blackjack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BlackjackApplication extends Application {

    private final Player player;
    private static Stage primaryStage;

    /**
     * The application has exactly one Player role.
     */
    public BlackjackApplication() {
        this.player = new Player();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(Objects.requireNonNull(getClass().getResource("/font/roboto_slab.ttf")).toString(), 10);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("playroom-bet-view.fxml"));
        Scene betViewScene = new Scene(fxmlLoader.load());

        PlayroomBetController betController = fxmlLoader.getController();
        betController.loadContents(player);

        primaryStage = stage;
        stage.setTitle("Blackjack Game");
        stage.getIcons().add(new Image("/logo.png"));
        stage.setScene(betViewScene);
        stage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}
