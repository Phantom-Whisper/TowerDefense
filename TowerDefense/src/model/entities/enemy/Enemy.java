package model.entities.enemy;

import model.entities.position.Position;

public abstract class Enemy {
    protected double health;
    protected Position pos;

    public Enemy(double health, int x, int y){

        this.health = health;
        pos = new Position(x, y);
    }

    public int getX() {
        return pos.getX();
    }

    public int getY(){
        return pos.getY();
    }

    public void takeDamage(double damage) {
    }
}
