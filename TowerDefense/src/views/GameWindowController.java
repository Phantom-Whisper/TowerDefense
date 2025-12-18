package views;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

public class GameWindowController {
    @FXML
    private Parent boardView;
    @FXML
    private Board boardViewController;
    @FXML
    private InfoViewController infoViewController;
    @FXML
    private ShopViewController shopViewController;

    public Board getBoardView() {
        return boardViewController;
    }
}
