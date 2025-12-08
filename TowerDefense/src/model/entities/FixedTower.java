package model.entities;

public class FixedTower extends Tower{
    public FixedTower(int x, int y, double damage, double cooldown, float cost){
        super(x, y, damage, cooldown, cost, "Fixed Tower","A fixed defense tower shooting in one and only one direction");
    }
}
