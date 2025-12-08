package model.entities;

public abstract class Tower {
    protected int x;
    protected int y;
    String name;
    String description;
    protected double damage;
    protected double cooldown;
    protected double timer = 0;
    protected float cost;
    // TODO:
    //  - Ctor
    //  - maybe a dependancy to a strategy of targeting??
    //  - maybe a double timer idk??
    //  - update()
    //  - attack()

    public Tower(int x, int y, double damage, double cooldown, float cost, String name, String description){
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
}
