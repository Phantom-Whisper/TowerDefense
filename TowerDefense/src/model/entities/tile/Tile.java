package model.entities.tile;

import model.entities.position.Position;

public abstract class Tile {
    protected Position pos;

    public Tile(int x, int y) {
        pos = new Position(x,y);
    }

    public int getX() { return pos.getX(); }
    public int getY() { return pos.getY(); }

    public abstract boolean isWalkable();
    public abstract boolean isBuildable();

}
