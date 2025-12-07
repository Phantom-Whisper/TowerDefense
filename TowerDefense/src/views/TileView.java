package views;

import javax.swing.*;

public class TileView extends StackPane {
    public TileView(Tile tile) {

        setPrefSize(32, 32);

        if (tile instanceof GrassTile) {
            setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        } else if (tile instanceof RoadTile) {
            setStyle("-fx-background-color: saddlebrown; -fx-border-color: black;");
        } else if (tile instanceof StartingTile) {
            setStyle("-fx-background-color: green; -fx-border-color: black;");
        } else if (tile instanceof EndingTile) {
            setStyle("-fx-background-color: red; -fx-border-color: black;");
        } else {
            setStyle("-fx-background-color: grey; -fx-border-color: black;");
        }
    }
}
