package world.homans.blackjack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class PlayroomBetController {

    Player player;
    Game game;

    @FXML Text txtBalance;
    @FXML Button btnDeal;
    @FXML Button btnCancel;

    /**
     * Initialize a new game for the player.
     * @param player player to been shown on the UI as well as who plays the game
     */
    public void loadContents(Player player) {
        this.player = player;
        this.game = new Game(player);
    }

    /**
     * Player adds a $100 value chip to the bet.
     */
    @FXML
    protected void onBet100ChipClicked() {
        game.increaseBet(new Chip(100));
        btnCancel.setDisable(false);
        btnDeal.setDisable(false);
        System.out.println("Add a $100 chip to the bet");
    }

    /**
     * Player adds a $500 value chip to the bet.
     */
    @FXML
    protected void onBet500ChipClicked() {
        game.increaseBet(new Chip(500));
        btnCancel.setDisable(false);
        btnDeal.setDisable(false);
        System.out.println("Add a $500 chip to the bet");
    }

    /**
     * Player adds a $1000 value chip to the bet.
     */
    @FXML
    protected void onBet1000ChipClicked() {
        game.increaseBet(new Chip(1000));
        btnCancel.setDisable(false);
        btnDeal.setDisable(false);
        System.out.println("Add a $1000 chip to the bet");
    }

    /**
     * Player adds a $5000 value chip to the bet.
     */
    @FXML
    protected void onBet5000ChipClicked() {
        game.increaseBet(new Chip(5000));
        btnCancel.setDisable(false);
        btnDeal.setDisable(false);
        System.out.println("Add a $5000 chip to the bet");
    }

    /**
     * Cancel the bet and return all chips.
     */
    @FXML
    protected void onCancelButtonClick() {
        game.clearBet();
        btnCancel.setDisable(true);
        btnDeal.setDisable(true);
        System.out.println("Bet Canceled");
    }

    /**
     * Deal the bet (chips) and start the game.
     * Switch to game scene and update balance text in UI.
     */
    @FXML
    protected void onDealButtonClick() {
        player.deal(game.getBettingBox());
        game.start();
        switchToGameScene();
        System.out.println("Bet Dealt Game Start");
    }

    private void switchToGameScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(BlackjackApplication.class.getResource("playroom-game-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 960, 540);
            BlackjackApplication.getPrimaryStage().setScene(scene);
            PlayroomGameController gameController = fxmlLoader.getController();
            gameController.loadContents(player, game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
