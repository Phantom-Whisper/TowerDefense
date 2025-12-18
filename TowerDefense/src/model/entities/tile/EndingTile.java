package model.entities.tile;

public class EndingTile extends Tile {
    public EndingTile(int x, int y) {
        super(x,y);
    }

    @Override
    public boolean isWalkable() { return true; }
    @Override
    public boolean isBuildable() { return false; }
}
