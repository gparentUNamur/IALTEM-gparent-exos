package be.pj.threads.philosophe.boulets;


import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Casserole {

    private ArrayList<Boulet> boulets = new ArrayList<>();

    public synchronized Boulet getElement(Semaphore s) {
        while (s.availablePermits() != 0) {
            if (boulets.isEmpty()) {
                try {
                    wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                return boulets.remove(0);
            }
        }
        return null;
    }

    public synchronized void addElement(Boulet element) {
        this.boulets.add(element);
        notifyAll();
    }
}
