package model.entities;

public abstract class Tower {
    protected int x;
    protected int y;
    protected double damage;
    protected double cooldown;
    protected int cost;
    // TODO:
    //  - Ctor
    //  - maybe a dependancy to a strategy of targeting??
    //  - maybe a double timer idk??
    //  - update()
    //  - attack()
    public double getX() { return x; }
    public double getY() { return y; }
}
