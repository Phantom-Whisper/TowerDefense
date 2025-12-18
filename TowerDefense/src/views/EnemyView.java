package views;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import model.entities.enemy.Enemy;


public class EnemyView extends Circle {
    private final Enemy enemy;

    public EnemyView(Enemy enemy) {
        super(15, Color.RED); // rayon 15px
        this.enemy = enemy;

        setTranslateX(enemy.getX() * 40 + 20); // centrer sur la case
        setTranslateY(enemy.getY() * 40 + 20);
    }

    public void update() {
        setTranslateX(enemy.getX() * 40 + 20);
        setTranslateY(enemy.getY() * 40 + 20);
    }
}
