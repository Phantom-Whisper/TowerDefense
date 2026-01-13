package views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.entities.projectile.Projectile;

public class ProjectileView extends Pane {
    private final Projectile projectile;
    private final ImageView image;
    private static final int SIZE = 64;

    public ProjectileView(Projectile projectile){
        this.projectile = projectile;
        Image img = ImageResource.getImage(projectile.getSpritePath());
        this.image = new ImageView(img);

        image.setFitHeight(SIZE * 0.5);
        image.setFitWidth(SIZE * 0.5);
        this.getChildren().add(image);
        update();
    }

    public void update(){
        // On multiplie par 64 pour passer des coordonnées "grille" aux coordonnées "pixels"
        setLayoutX(projectile.getX() * 64);
        setLayoutY(projectile.getY() * 64);
    }
}
