package model.utils.loader;

import model.entities.Tile;
import model.entities.TileType;
import views.Board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TextLoader implements ILoader<Tile> {

    @Override
    public void Load(String path) throws IOException {
        Board board = new Board();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            int x = 0, y = 0;
            Tile tile;
            String out;
            while((out = reader.readLine()) != null){
                for (int i = 0; i < out.length(); i++) {
                    char c = out.charAt(i);
                    switch (c){
                        case 'S':
                            tile = new Tile(x,y, TileType.START);
                            board.add(tile);
                            break;
                        case '.':
                            tile = new Tile(x,y, TileType.GRASS);
                            board.add(tile);
                            break;
                        case 'R':
                            tile = new Tile(x,y, TileType.ROAD);
                            board.add(tile);
                            break;
                        case 'E':
                            tile = new Tile(x,y, TileType.END);
                            board.add(tile);
                            break;
                        default:
                            break;
                    }
                    x++;
                }
                y++;
            }
            board.setX(x);
            board.setY(y);
        }
    }
}
