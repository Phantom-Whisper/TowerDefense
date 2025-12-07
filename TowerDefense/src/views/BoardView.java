package views;

import javafx.scene.layout.GridPane;
import model.entities.Tile;
import model.entities.BoardModel;

public class BoardView {
    @FXML
    private GridPane grid;

    public void display(BoardModel model) {

        Tile[][] tiles = model.getTiles();

        grid.getChildren().clear();

        for (int y = 0; y < model.getHeight(); y++) {
            for (int x = 0; x < model.getWidth(); x++) {

                Tile tile = tiles[y][x];
                TileView tileView = new TileView(tile);

                grid.add(tileView, x, y);
            }
        }
    }
}
