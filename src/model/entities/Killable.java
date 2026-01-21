package model.entities;

public abstract class Killable extends Element {
    protected double health;

    /**
     * Killable constructor.
     * @param x X position on the game board.
     * @param y Y position on the game board.
     * @param health Killable health when spawning
     */
    public Killable(double x, double y, double health){
        super(x, y);
        this.health = health;
    }

    /**
     * Deals damage to a killable.
     * @param damage an amount of damage to deal to a killable.
     */
    public void takeDamage(double damage){
        health -= damage;
        if (health < 0){
            health = 0;
        }
    }

    /**
     * Tells if the killable element's dead or not.
     * @return true if health's under or equal to 0, false otherwise.
     */
    public boolean isDead(){
        return health <= 0;
    }

    public double getHealth() { return health; }
}
