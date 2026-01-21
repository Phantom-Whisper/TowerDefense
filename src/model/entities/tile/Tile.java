package model.entities.tile;

import model.entities.Element;

public abstract class Tile extends Element {
    public Tile(double x, double y) {
        super(x, y);
    }

    public abstract boolean isWalkable();
    public abstract boolean isBuildable();

}
