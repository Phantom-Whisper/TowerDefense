package model.entities.enemy;

import model.entities.Killable;
import model.entities.board.BoardModel;
import model.entities.tile.Tile;

import java.util.List;
import java.util.Random;

public abstract class Enemy extends Killable {
    protected double speed;
    protected Tile currentTarget;
    protected Tile lastTile;

    public Enemy(double x, double y, double health, double speed){
        super(x, y, health);
        this.speed = speed;
    }

    public void update(BoardModel model) {
        if (currentTarget == null) {
            Tile start = model.getStartingTile();
            lastTile = start;
            List<Tile> next = model.getValidNeighbors(start, null);
            if (!next.isEmpty()) currentTarget = next.getFirst();
            return;
        }

        double dx = currentTarget.getX() - position.getX();
        double dy = currentTarget.getY() - position.getY();
        double dist = Math.sqrt(dx * dx + dy * dy);

        if (dist < speed) {
            position.setX(currentTarget.getX());
            position.setY(currentTarget.getY());
            Tile reached = currentTarget;

            List<Tile> options = model.getValidNeighbors(reached, lastTile);
            if (!options.isEmpty()) {
                lastTile = reached;
                currentTarget = options.get(new Random().nextInt(options.size()));
            } else {
                currentTarget = null;
            }
        } else {
            position.setX(position.getX() +(dx / dist) * speed);
            position.setY(position.getY() + (dy / dist) * speed);
        }
    }

    public boolean isAtEnd() { return currentTarget == null && lastTile instanceof model.entities.tile.EndingTile; }
    public abstract String getSpritePath();
    public Tile getCurrentTarget() { return currentTarget; }
    public Tile getLastTile() { return lastTile; }
    public double getSpeed() { return speed; }
    public void setLastTile(Tile lastTile) { this.lastTile = lastTile; }
    public void setCurrentTarget(Tile currentTarget) { this.currentTarget = currentTarget; }
}
