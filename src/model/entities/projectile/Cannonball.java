package model.entities.projectile;

import model.entities.enemy.Enemy;

public class Cannonball extends Projectile {

    public Cannonball(double x, double y, Enemy target, double damage) {
        super(x, y, target, damage);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public String getSpritePath() {
        return "/assets/cannonball.png";
    }
}