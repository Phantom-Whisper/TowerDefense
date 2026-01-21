package factory;

import model.entities.tile.*;

public class TileFactory {
    public static Tile createTileFromChar(char c, int x, int y) {
        return switch (c){
            case 'S' -> new StartingTile(x, y);
            case 'E'  -> new EndingTile(x, y);
            case 'R' -> new RoadTile(x, y);
            case 'G' -> new GrassTile(x, y);
            default -> throw new IllegalArgumentException("Unknown tile: " + c);
        };
    }
}
