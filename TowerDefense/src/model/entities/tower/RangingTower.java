package model.entities.tower;

public class RangingTower extends Tower {
    public RangingTower(int x, int y, double damage, double cooldown, int cost){
        super(x, y, damage, cooldown, cost, "Ranging Tower","A rotative defense tower shooting any target in a certain range");
    }
}
