package model.entities.enemy;

public class Goblin extends Enemy {
    public Goblin(double x, double y) {
        super(x,y,50, 0.02);
    }

    public void update(){

    }

    @Override
    public String getSpritePath() {
        return "/assets/goblin.gif";
    }
}
