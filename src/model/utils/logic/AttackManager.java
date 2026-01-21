package model.utils.logic;

import model.entities.board.BoardModel;
import model.entities.enemy.Enemy;
import model.entities.projectile.Cannonball;
import model.entities.projectile.Projectile;
import model.entities.tower.Tower;
import model.utils.observer.Observer;

public class AttackManager extends Observer {
    private final BoardModel model;
    private final ProjectileManager projectileManager;

    public AttackManager(BoardModel model, ProjectileManager pm) {
        this.model = model;
        this.projectileManager = pm;
    }

    @Override
    public void update() {
        for (Tower tower : model.getTowers()) {
            tower.update(1.0);

            if (tower.canAttack()) {
                Enemy target = findClosestEnemy(tower);
                if (target != null) {
                    Projectile p = new Cannonball(tower.getX(), tower.getY(), target, tower.getDamage());
                    projectileManager.addProjectile(p);

                    tower.resetCooldown();
                }
            }
        }
    }

    private Enemy findClosestEnemy(Tower t) {
        Enemy closest = null;
        double minDist = 3.0;

        for (Enemy e : model.getEnemies()) {
            double dist = Math.sqrt(Math.pow(e.getX() - t.getX(), 2) + Math.pow(e.getY() - t.getY(), 2));
            if (dist < minDist) {
                minDist = dist;
                closest = e;
            }
        }
        return closest;
    }
}