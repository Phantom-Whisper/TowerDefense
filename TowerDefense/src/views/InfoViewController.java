package views;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InfoViewController {
    @FXML
    private Label turnLabel;
    @FXML private Label moneyLabel;

    private final IntegerProperty turn = new SimpleIntegerProperty(1);
    private final IntegerProperty money = new SimpleIntegerProperty(100);

    public void initialize() {
        turnLabel.textProperty().bind(turn.asString());
        moneyLabel.textProperty().bind(
                Bindings.format("$%d", money.get())
        );
    }

    public void setTurn(int value) {
        turn.set(value);
    }

    public void setMoney(int value) {
        money.set(value);
    }
}
