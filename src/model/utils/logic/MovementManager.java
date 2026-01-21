package model.utils.logic;

import model.entities.board.BoardModel;
import model.entities.enemy.Enemy;
import model.entities.tile.Tile;
import model.utils.observer.Observer;

import java.util.ArrayList; // AJOUTÉ : Import manquant
import java.util.List;
import java.util.Random;

public class MovementManager extends Observer {
    private final BoardModel model;
    private final Random random = new Random();

    public MovementManager(BoardModel model) {
        this.model = model;
    }

    @Override
    public void update() {
        for (Enemy e : new ArrayList<>(model.getEnemies())) {
            updateEnemyPosition(e);
        }
    }

    private void updateEnemyPosition(Enemy e) {
        if (e.getCurrentTarget() == null) {
            Tile start = model.getStartingTile();
            if (start == null) return;

            List<Tile> next = model.getValidNeighbors(start, null);
            if (!next.isEmpty()) {
                e.setX(start.getX());
                e.setY(start.getY());
                e.setLastTile(start);
                e.setCurrentTarget(next.getFirst());
            }
            return;
        }

        double dx = e.getCurrentTarget().getX() - e.getX();
        double dy = e.getCurrentTarget().getY() - e.getY();
        double dist = Math.sqrt(dx * dx + dy * dy);

        if (dist < e.getSpeed()) {
            e.setX(e.getCurrentTarget().getX());
            e.setY(e.getCurrentTarget().getY());

            List<Tile> options = model.getValidNeighbors(e.getCurrentTarget(), e.getLastTile());

            if (!options.isEmpty()) {
                e.setLastTile(e.getCurrentTarget());
                e.setCurrentTarget(options.get(random.nextInt(options.size())));
            } else {
                e.setCurrentTarget(null);
            }
        } else {
            e.setX(e.getX() + (dx / dist) * e.getSpeed());
            e.setY(e.getY() + (dy / dist) * e.getSpeed());
        }
    }
}