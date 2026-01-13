package model.entities.tower;

import model.entities.Element;

public abstract class Tower extends Element {
    protected String name;
    protected String description;
    protected String spritePath;
    protected double damage;
    protected double cooldown;
    protected double timer = 0;
    protected int cost;
    // TODO:
    //  - Ctor
    //  - maybe a dependancy to a strategy of targeting??
    //  - maybe a double timer idk??
    //  - update()
    //  - attack()

    public Tower(double x, double y, double damage, double cooldown, int cost, String name, String description, String spritePath){
        super(x, y);
        this.damage = damage;
        this.cooldown = cooldown;
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.spritePath = spritePath;
    }

    // Dans Tower.java
    public boolean canAttack() {
        return timer <= 0;
    }

    public void resetCooldown() {
        this.timer = this.cooldown * 60; // cooldown en secondes * 60 ticks
    }

    public void update(double delta) {
        if (timer > 0) timer -= delta;
    }

    public double getDamage() { return damage; }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public String getSpritePath(){
        return spritePath;
    }
}
