package model.entities.tower;

public class FixedTower extends Tower {
    public FixedTower(double x, double y, double damage, double cooldown, int cost){
        super(x, y, damage, cooldown, cost, "Fixed Tower",
                "A fixed defense tower shooting in one and only one direction",
                "/assets/fixed_tower.gif");
    }

    public void update(){

    }

    @Override
    public Tower createAt(double x, double y) {
        return new FixedTower(x, y, this.damage, this.cooldown, this.cost);
    }
}
