package views;

import javafx.scene.layout.GridPane;
import model.entities.Tile;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Tile> board = new ArrayList<Tile>();
    int x, y;


    public void add(Tile tile) {
        board.add(tile);
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Board (){
        //GridPane grid = new GridPane();
    }
}
