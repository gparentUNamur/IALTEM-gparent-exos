package be.pj.patterns.visitor;

public interface Observable {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
