package model.entities;

public abstract class Enemy {
    protected double health;

    public Enemy(double health){
        this.health = health;
    }
    public void takeDamage(double damage) {
    }
}
