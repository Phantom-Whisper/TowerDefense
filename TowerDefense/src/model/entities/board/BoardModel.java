package model.entities.board;

import model.entities.enemy.Enemy;
import model.entities.enemy.Goblin;
import model.entities.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class BoardModel {
    private final int width;
    private final int height;
    private final List<Tile> tiles;
    private final List<Enemy> enemies = new ArrayList<>();;

    public BoardModel(int width, int height, List<Tile> tiles) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public List<Tile> getTiles() { return tiles; }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void removeEnemy(Enemy e) {
        enemies.remove(e);
    }
}
