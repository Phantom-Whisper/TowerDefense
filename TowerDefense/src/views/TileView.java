package views;

import javafx.beans.binding.StringBinding;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.entities.tile.GrassTile;
import model.entities.tile.RoadTile;
import model.entities.tile.StartingTile;
import model.entities.tile.EndingTile;
import model.entities.tile.Tile;

public class TileView extends Pane {
    public TileView(Tile tile) {
        // TODO:
        //  - find a way to make the panes responsive
        setPrefSize(64, 64);

        switch (tile) {
            case GrassTile grassTile -> setStyle("-fx-background-color: green; -fx-border-color: black;");
            case RoadTile roadTile -> setStyle("-fx-background-color: saddlebrown; -fx-border-color: black;");
            case StartingTile startingTile -> setStyle("-fx-background-color: saddlebrown; -fx-border-color: black;");
            case EndingTile endingTile -> setStyle("-fx-background-color: saddlebrown; -fx-border-color: black;");
            case null, default -> setStyle("-fx-background-color: grey; -fx-border-color: black;");
        }
    }
}
