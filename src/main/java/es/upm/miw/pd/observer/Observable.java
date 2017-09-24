package es.upm.miw.pd.observer;

import java.util.HashSet;
import java.util.Set;

public class Observable {
    private final Set<Observer> observers = new HashSet<Observer>();

    public void addObserver(Observer observador) {
        this.observers.add(observador);
    }

    public void removeObserver(Observer observador) {
        this.observers.remove(observador);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
