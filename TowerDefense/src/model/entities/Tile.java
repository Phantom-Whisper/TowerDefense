package model.entities;

public class Tile {
    private int x,y;
    private final TileType type;

    public Tile(int x, int y, TileType type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TileType getType() {
        return type;
    }
}
