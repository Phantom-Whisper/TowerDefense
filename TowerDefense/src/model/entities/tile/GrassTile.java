package model.entities.tile;

public class GrassTile extends Tile {
    public GrassTile(double x, double y) {
        super(x, y);
    }

    public void update(){

    }

    @Override
    public boolean isWalkable() { return false; }
    @Override
    public boolean isBuildable() { return true; }
}