package model.entities;

import model.entities.position.Position;

public abstract class Element {
    /**
     * Element x & y position on the game board
     */
    protected Position position;

    public Element(double x, double y){
        position = new Position(x, y);
    }

    /**
     * How an Element behave through the game loop.
     */
    public abstract void update();

    // Getters
    public double getX() { return position.getX(); }
    public double getY() { return position.getY(); }
    public void setX(double x) { position.setX(x); }
    public void setY(double y) { position.setY(y); }
}
