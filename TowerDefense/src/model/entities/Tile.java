package model.entities;

public abstract class Tile {
    protected final int x;
    protected final int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public abstract boolean isWalkable();
    public abstract boolean isBuildable();
}
