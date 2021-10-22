package world.homans.blackjack;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BlackjackController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onNewGameButtonClick() {
        welcomeText.setText("Welcome to Blackjack Game!");
    }
}
