package model.entities;

public class GrassTile extends Tile {
    public GrassTile(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isWalkable() { return false; }
    @Override
    public boolean isBuildable() { return true; }
}