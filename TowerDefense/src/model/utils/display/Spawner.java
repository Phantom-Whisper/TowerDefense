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
    private Random random = new Random();

    public Spawner(Board board, BoardModel model) {
        this.board = board;
        this.model = model;

    }

    @Override
    public void update() {
        ticks++;
        if (ticks % 120 == 0) {
            Tile start = model.getStartingTile();
            if (start != null) {
                model.addEnemy(new Goblin(start.getX(), start.getY()));
            }
        }
        board.updateView();
    }
}
