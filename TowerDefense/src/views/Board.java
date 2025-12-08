package views;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import model.entities.Tile;
import model.entities.BoardModel;

public class Board {
    @FXML
    private GridPane grid;

    public void display(BoardModel model) {

        Tile[][] tiles = model.getTiles();

        grid.getChildren().clear();

        for (int y = 0; y < model.getHeight(); y++) {
            for (int x = 0; x < model.getWidth(); x++) {
                Tile tile = tiles[y][x];
                StackPane pane = new StackPane();
                TileView tileView = new TileView(tile);
                grid.add(tileView, x, y);
            }
        }
    }
}
