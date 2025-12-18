package model.entities.tile;

public class RoadTile extends Tile {
    public RoadTile(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isWalkable() { return true; }

    @Override
    public boolean isBuildable() { return false; }
}
