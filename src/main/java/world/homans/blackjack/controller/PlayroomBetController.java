package world.homans.blackjack.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import world.homans.blackjack.BlackjackApplication;
import world.homans.blackjack.game.Chip;
import world.homans.blackjack.game.Game;
import world.homans.blackjack.role.Player;

public class PlayroomBetController {

    Player player;
    Game game;

    @FXML Text txtBetValue;
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
        updateScene();
    }

    /**
     * Player adds a $100 value chip to the bet.
     */
    @FXML
    protected void onBet100ChipClicked() {
        System.out.println("Add a $100 chip to the bet");
        game.increaseBet(new Chip(100));
        updateScene();
    }

    /**
     * Player adds a $500 value chip to the bet.
     */
    @FXML
    protected void onBet500ChipClicked() {
        System.out.println("Add a $500 chip to the bet");
        game.increaseBet(new Chip(500));
        updateScene();
    }

    /**
     * Player adds a $1000 value chip to the bet.
     */
    @FXML
    protected void onBet1000ChipClicked() {
        System.out.println("Add a $1000 chip to the bet");
        game.increaseBet(new Chip(1000));
        updateScene();
    }

    /**
     * Player adds a $5000 value chip to the bet.
     */
    @FXML
    protected void onBet5000ChipClicked() {
        System.out.println("Add a $5000 chip to the bet");
        game.increaseBet(new Chip(5000));
        updateScene();
    }

    /**
     * Cancel the bet and return all chips.
     */
    @FXML
    protected void onCancelButtonClick() {
        System.out.println("Bet Canceled");
        game.clearBet();
        updateScene();
    }

    /**
     * Deal the bet (chips) and start the game.
     * Switch to game scene and update balance text in UI.
     */
    @FXML
    protected void onDealButtonClick() {
        System.out.println("Bet Dealt Game Start");
        player.deal(game.getChips());
        game.start();
        switchToGameScene();
    }

    /**
     * Update player's balance in the scene.
     */
    private void updateScene() {
        if (game.getCurrentBetValue() == 0) {
            btnCancel.setDisable(true);
            btnDeal.setDisable(true);
        } else {
            btnCancel.setDisable(false);
            btnDeal.setDisable(false);
        }
        txtBetValue.setText(game.getCurrentBetValueFormatted());
        txtBalance.setText(player.getBalanceFormatted());
    }

    private void switchToGameScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(BlackjackApplication.class.getResource("playroom-game-view.fxml"));
        try {
            Parent root = fxmlLoader.load();
            BlackjackApplication.getPrimaryStage().getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlayroomGameController gameController = fxmlLoader.getController();
        gameController.loadContents(player, game);
    }
}
