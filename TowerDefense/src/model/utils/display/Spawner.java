package model.utils.display;

import model.entities.board.BoardModel;
import model.entities.enemy.Goblin;
import model.entities.projectile.Cannonball;
import model.entities.tile.Tile;
import model.utils.observer.Observer;
import views.Board;

import java.util.Random;

public class Spawner extends Observer {
    private final Board board;
    private final BoardModel model;
    private int enemiesWaitingToSpawn = 0;
    private final int spawnInterval = 20;
    private Random random = new Random();

    public Spawner(Board board, BoardModel model) {
        this.board = board;
        this.model = model;

    }

    @Override
    public void update() {
        ticks++;
        if (ticks % 160 == 0) {
            this.enemiesWaitingToSpawn = random.nextInt(6) + 1;
        }

        if (enemiesWaitingToSpawn > 0 && ticks % spawnInterval == 0) {
            spawnOneEnemy();
            enemiesWaitingToSpawn--;
        }
        board.updateView();
    }

    private void spawnOneEnemy() {
        Tile start = model.getStartingTile();
        if (start != null) {
            double offsetX = (random.nextDouble() - 0.5) * 0.1;
            double offsetY = (random.nextDouble() - 0.5) * 0.1;

            model.addEnemy(new Goblin(start.getX() + offsetX, start.getY() + offsetY));
        }
    }
}
