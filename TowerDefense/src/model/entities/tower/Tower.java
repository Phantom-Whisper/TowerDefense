package model.entities.tower;

import model.entities.enemy.Enemy;

public abstract class Tower {
    protected int x;
    protected int y;
    protected String name;
    protected String description;
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

    public Tower(int x, int y, double damage, double cooldown, int cost, String name, String description){
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.cooldown = cooldown;
        this.cost = cost;
        this.name = name;
        this.description = description;
    }
    public void update(double delta){

    }

    public void attack(Enemy target){
        if (timer < cooldown){
            return;
        }
        target.takeDamage(damage);
    }
    public double getX() { return x; }
    public double getY() { return y; }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }
}
