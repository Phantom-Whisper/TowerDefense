package model.utils.thread;

import model.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Ticker implements Runnable {
    private final List<Observer> observers = new ArrayList<>();
    private boolean running = true;

    public void attach(Observer o) { observers.add(o); }

    public void stop(){
        running = false;
    }

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
