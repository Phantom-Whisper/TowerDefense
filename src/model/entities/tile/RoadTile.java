package model.entities.tile;

public class RoadTile extends Tile {
    public RoadTile(double x, double y) {
        super(x, y);
    }

    public void update(){

    }

    @Override
    public boolean isWalkable() { return true; }

    @Override
    public boolean isBuildable() { return false; }
}
