package model.entities;

public class StartingTile extends Tile {
    public StartingTile(int x, int y) {
        super(x,y);
    }

    @Override
    public boolean isWalkable() { return true; }

    @Override
    public boolean isBuildable() { return false; }
}
