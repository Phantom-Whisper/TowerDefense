package model.entities.board;

import model.entities.endEntity.Castle;
import model.entities.enemy.Enemy;
import model.entities.tile.EndingTile;
import model.entities.tile.RoadTile;
import model.entities.tile.StartingTile;
import model.entities.tile.Tile;
import model.entities.tower.FixedTower;
import model.entities.tower.RangingTower;
import model.entities.tower.Tower;

import java.util.ArrayList;
import java.util.List;

public class BoardModel {
    private final int width; // Nombre de colonnes (int)
    private final int height; // Nombre de lignes (int)
    private final Tile[][] grid;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Tower> towers = new ArrayList<>();
    private Castle castle;

    public BoardModel(int width, int height, List<Tile> tiles) {
        this.width = width;
        this.height = height;
        this.grid = new Tile[width][height];

        for (Tile tile : tiles) {
            int x = (int) tile.getX();
            int y = (int) tile.getY();

            if (x >= 0 && x < width && y >= 0 && y < height) {
                grid[x][y] = tile;
                if (tile instanceof model.entities.tile.EndingTile) {
                    this.castle = new Castle(x, y, 3);
                }
            }
        }
    }

    public void createTower(String type, double col, double row) {
        int c = (int) col;
        int r = (int) row;

        Tower tower;
        // TODO
        // - Changer ça c'est nul, faut recupérer les stats depuis ShopViewController

        if (type.contains("FixedTower")) {
            tower = new FixedTower(c, r, 25, 1, 50);
        } else {
            tower = new RangingTower(c, r, 20, 2, 80);
        }
        this.addTower(tower);
    }

    public Tile getStartingTile() {
        for (Tile[] row : grid)
            for (Tile t : row) if (t instanceof StartingTile) return t;
        return null;
    }

    public List<Tile> getValidNeighbors(Tile current, Tile last) {
        List<Tile> neighbors = new ArrayList<>();
        double[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (double[] d : dirs) {
            Tile n = getTile(current.getX() + d[0], current.getY() + d[1]);

            if (n != last && (n instanceof RoadTile || n instanceof EndingTile)) {
                neighbors.add(n);
            }
        }
        return neighbors;
    }

    public void addTower(Tower newTower) {
        if (newTower != null) {
            towers.add(newTower);
        }
    }

    public List<Tower> getTowers() {
        return towers;
    }

    private boolean isTowerAt(int col, int row) {
        return towers.stream()
                .anyMatch(t -> (int)t.getX() == col && (int)t.getY() == row);
    }

    public boolean isPlacementValid(double col, double row) {
        int c = (int) col;
        int r = (int) row;

        if (c < 0 || c >= width || r < 0 || r >= height) return false;

        Tile targetTile = grid[c][r];

        return targetTile != null
                && targetTile.isBuildable()
                && !isTowerAt(c, r);
    }

    // Getters
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    public Tile getTile(double x, double y) {
        int ix = (int) x;
        int iy = (int) y;

        if (ix < 0 || ix >= width || iy < 0 || iy >= height) return null;
        return grid[ix][iy];
    }

    public Tile[][] getGrid() { return grid; }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Castle getCastle() {
        return castle;
    }

    public void removeEnemy(Enemy e) {
        enemies.remove(e);
    }
}