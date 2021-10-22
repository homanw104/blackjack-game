module world.homans.blackjack {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens world.homans.blackjack to javafx.fxml;
    exports world.homans.blackjack;
}
