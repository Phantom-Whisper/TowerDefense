package model.utils.observer;

public abstract class Observer {
    protected int ticks = 0;

    public abstract void update();
}
