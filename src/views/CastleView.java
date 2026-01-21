package views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.entities.endEntity.Castle;
import java.util.Objects;

public class CastleView extends ImageView {
    public CastleView(Castle castle, double cellSize) {
        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/castle.gif")));
        this.setImage(img);

        this.setFitWidth(cellSize);
        this.setFitHeight(cellSize);

        this.setLayoutX(castle.getX() * cellSize);
        this.setLayoutY(castle.getY() * cellSize);

        this.setMouseTransparent(true);
    }
}