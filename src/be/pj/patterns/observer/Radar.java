package be.pj.patterns.observer;

import java.util.HashSet;
import java.util.Set;

public class Radar implements Observable {
    Set<Observer> observerSet = new HashSet<>();
    private int lastDetection = 0;

    public void detectRoadhog(int speed) {
        this.lastDetection = speed;
        notifyObservers();

    }

    public int getLastDetection() {
        return this.lastDetection;
    }

    @Override
    public void addObserver(Observer o) {
        this.observerSet.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observerSet.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : this.observerSet) {
            o.update();
        }
    }
}
