package model.utils.loader;

import factory.TileFactory;
import model.entities.tile.Tile;
import model.entities.board.BoardModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextLoader implements ILoader<BoardModel> {

    @Override
    public BoardModel load(String path) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        int height = lines.size();
        int width = lines.getFirst().length();

        List<Tile> tiles = new ArrayList<Tile>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char c = lines.get(y).charAt(x);
                tiles.add(TileFactory.createTileFromChar(c, x, y));
            }
        }

        return new BoardModel(width, height, tiles);
    }
}
