package world.homans.blackjack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class PlayroomGameController {

    Player player;
    Game game;

    @FXML Text txtBalance;
    @FXML Button btnStand;
    @FXML Button btnDouble;
    @FXML Button btnSurrender;
    @FXML Button btnHit;

    /**
     * Load the player and game context.
     * @param player player to been shown on the UI as well as who plays the game
     * @param game the game player has started
     */
    public void load(Player player, Game game) {
        this.player = player;
        this.game = game;
        txtBalance.setText(player.getBalanceFormatted());
    }

    /**
     * Player takes no more cards.
     */
    @FXML
    protected void onStandButtonClick() {
        game.getDealer().hitTillSeventeen(game.getDeck());
        game.checkAfterStand();
        System.out.println("Player Stand");
    }

    /**
     * Player takes another card.
     */
    @FXML
    protected void onHitButtonClick() {
        player.hit(game.getDeck());
        game.checkAfterHit();
        System.out.println("Player Hit");
    }

    /**
     * Player double the bet and take exactly one more card.
     */
    @FXML
    protected void onDoubleButtonClick() {
        player.doubleDeal();
        System.out.println("Player Double");
    }

    /**
     * Player surrender. Forfeit half the bet and end the hand immediately.
     */
    @FXML
    protected void onSurrenderButtonClick() {

        System.out.println("Player Surrendered");
    }

    private void switchToBetScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(BlackjackApplication.class.getResource("playroom-bet-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 960, 540);
            BlackjackApplication.getPrimaryStage().setScene(scene);
            PlayroomBetController betController = fxmlLoader.getController();
            betController.load(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
