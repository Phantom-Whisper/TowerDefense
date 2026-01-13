package model.entities.projectile;

import model.entities.Killable;
import model.entities.enemy.Enemy;

public abstract class Projectile extends Killable {
    protected String spritePath;
    protected Enemy target;
    protected double damage;
    protected double speed = 0.2;

    public Projectile(double x, double y, Enemy target, double damage) {
        super(x, y, 1);
        this.target = target;
        this.damage = damage;
    }

    public void update() {
        if (target != null) {
            double dx = target.getX() - getX();
            double dy = target.getY() - getY();
            double dist = Math.sqrt(dx * dx + dy * dy);

            if (dist > 0) {
                setX( getX() + (dx / dist) * speed);
                setY(getY() +(dy / dist) * speed);
            }
        }
    }

    public boolean hasHitTarget() {
        if (target == null) return false;
        double dx = target.getX() - getX();
        double dy = target.getY() - getY();
        double dist = Math.sqrt(dx * dx + dy * dy);
        return dist < 0.3;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public Enemy getTarget() {
        return target;
    }

    public double getDamage() {
        return damage;
    }
}