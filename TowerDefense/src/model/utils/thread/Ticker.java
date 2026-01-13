package model.utils.thread;

import model.entities.board.BoardModel;
import model.entities.enemy.Enemy;
import model.utils.logic.CollisionManager;
import model.utils.logic.MovementManager;
import model.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Ticker implements Runnable {
    private final List<Observer> observers = new ArrayList<>();
    private boolean running = true;

    public void attach(Observer o) { observers.add(o); }

    @Override
    public void run() {
        while (running) {
            for (Observer o : observers) o.update();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
