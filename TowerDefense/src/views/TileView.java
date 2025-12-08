package views;

import javafx.scene.layout.Pane;
import model.entities.GrassTile;
import model.entities.RoadTile;
import model.entities.StartingTile;
import model.entities.EndingTile;
import model.entities.Tile;

import javax.swing.*;

public class TileView extends Pane {
    public TileView(Tile tile) {
        // TODO:
        //  - find a way to make the panes responsive
        // setPrefSize(128, 128);

        switch (tile) {
            case GrassTile grassTile -> setStyle("-fx-background-color: green; -fx-border-color: black;");
            case RoadTile roadTile -> setStyle("-fx-background-color: saddlebrown; -fx-border-color: black;");
            case StartingTile startingTile -> setStyle("-fx-background-color: saddlebrown; -fx-border-color: black;");
            case EndingTile endingTile -> setStyle("-fx-background-color: saddlebrown; -fx-border-color: black;");
            case null, default -> setStyle("-fx-background-color: grey; -fx-border-color: black;");
        }
    }
}
