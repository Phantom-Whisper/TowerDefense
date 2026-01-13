package model.utils.logic;

import model.entities.board.BoardModel;
import model.entities.enemy.Enemy;
import model.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager extends Observer {
    private final BoardModel model;

    public CollisionManager(BoardModel model) {
        this.model = model;
    }

    public void checkCollisions() {
        List<Enemy> toRemove = new ArrayList<>();

        for (Enemy e : model.getEnemies()) {
            if (e.isDead()) toRemove.add(e);
            double distToCastle = Math.sqrt(
                    Math.pow(e.getX() - model.getCastle().getX(), 2) +
                            Math.pow(e.getY() - model.getCastle().getY(), 2)
            );

            if (distToCastle < 0.1) {
                model.getCastle().takeDamage(1);
                toRemove.add(e);
                System.out.println("Le château a été touché !");
            }
        }

        model.getEnemies().removeAll(toRemove);
    }

    @Override
    public void update() {
        checkCollisions();
    }
}
