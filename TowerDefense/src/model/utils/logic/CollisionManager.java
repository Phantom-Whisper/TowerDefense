package model.utils.logic;

import model.entities.board.BoardModel;
import model.entities.enemy.Enemy;
import model.utils.observer.Observer;
import model.utils.thread.Ticker;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager extends Observer {
    private final BoardModel model;
    private final Ticker ticker;
    private final Runnable onGameOver;

    public CollisionManager(BoardModel model, Ticker ticker, Runnable onGameOver) {
        this.model = model;
        this.ticker = ticker;
        this.onGameOver = onGameOver;
    }

    public void checkCollisions() {
        List<Enemy> toRemove = new ArrayList<>();

        for (Enemy e : model.getEnemies()) {
            if (e.isDead()){
                toRemove.add(e);
                model.addMoney(20);
            }
            double dx = e.getX() - model.getCastle().getX();
            double dy = e.getY() - model.getCastle().getY();
            double distToCastle = (dx * dx) + (dy * dy);

            if (distToCastle == 0) {
                model.getCastle().takeDamage(1);
                toRemove.add(e);

                if (model.getCastle().isDead()) {
                    handleGameOver();
                    return;
                }
            }
        }

        model.getEnemies().removeAll(toRemove);
    }

    private void handleGameOver() {
        ticker.stop();
        onGameOver.run();
    }

    @Override
    public void update() {
        checkCollisions();
    }
}
