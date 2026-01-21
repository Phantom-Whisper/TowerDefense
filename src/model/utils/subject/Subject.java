package model.utils.subject;

import model.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void attach(Observer obs) { observers.add(obs); }
    public void detach(Observer obs) { observers.remove(obs); }
}
