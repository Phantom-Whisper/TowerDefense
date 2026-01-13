package views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.entities.enemy.Enemy;
import java.util.Objects;

public class EnemyView extends Pane {
    private final Enemy enemy;
    private final ImageView imageView;
    private static final int TILE_SIZE = 64;

    public EnemyView(Enemy enemy) {
        this.enemy = enemy;
        Image img = ImageResource.getImage(enemy.getSpritePath());
        this.imageView = new ImageView(img);

        imageView.setFitWidth(64 * 0.8);
        imageView.setFitHeight(64 * 0.8);
        this.getChildren().add(imageView);
        this.setCache(false);
        this.setMouseTransparent(true);
        update();
    }

    /**
     * Met à jour la position visuelle en fonction des coordonnées double de l'ennemi
     */
    // Dans EnemyView.java
    public void update() {
        // Si tu veux que le centre de l'ennemi soit au centre de la case :
        setLayoutX(enemy.getX() * TILE_SIZE);
        setLayoutY(enemy.getY() * TILE_SIZE);
    }

    public Enemy getEnemy() {
        return this.enemy;
    }
}