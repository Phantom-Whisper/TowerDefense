package views;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.entities.enemy.Enemy;
import model.entities.tile.Tile;
import model.entities.board.BoardModel;

import java.util.List;

public class Board {
    @FXML
    private GridPane grid;
    private BoardModel model;

    public void setModel(BoardModel model){
        this.model = model;
    }

    public void display(BoardModel model) {

        List<Tile> tiles = model.getTiles();

        grid.getChildren().clear();

        for (int i = 0; i < model.getTiles().size(); i++){
            Tile tile = tiles.get(i);
            TileView tileView = new TileView(tile);
            grid.add(tileView, tile.getX(), tile.getY());
        }

        for (Enemy enemy : model.getEnemies()) {
            EnemyView enemyView = new EnemyView(enemy);
            grid.add(enemyView, enemy.getX(), enemy.getY());
        }
    }
}
