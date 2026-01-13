package model.utils.logic;

import model.entities.projectile.Projectile;
import model.utils.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class ProjectileManager extends Observer {
    private final List<Projectile> projectiles = new ArrayList<>();

    public void addProjectile(Projectile p) {
        projectiles.add(p);
    }

    @Override
    public void update() {
        List<Projectile> toRemove = new ArrayList<>();
        for (Projectile p : projectiles) {
            p.update();
            if (p.hasHitTarget()) {
                p.getTarget().takeDamage(p.getDamage());
                toRemove.add(p);
            }
        }
        projectiles.removeAll(toRemove);
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }
}