package views;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.entities.board.BoardModel;

public class InfoViewController {
    @FXML
    private Label moneyLabel;
    @FXML
    private Label timerLabel;

    private final IntegerProperty money = new SimpleIntegerProperty(0);
    private final StringProperty time = new SimpleStringProperty("00:00");

    public void initialize() {

        moneyLabel.textProperty().bind(Bindings.format("$%d", money));

        if (timerLabel != null) {
            timerLabel.textProperty().bind(time);
        }
    }

    public void updateInfo(BoardModel model) {
        Platform.runLater(() -> {
            money.set((int) model.getMoney());
            time.set(model.getFormattedTime());
        });
    }
}
