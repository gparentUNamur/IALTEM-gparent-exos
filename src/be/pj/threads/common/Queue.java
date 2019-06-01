package be.pj.threads.common;

import java.util.ArrayList;

public class Queue<E> {
    private ArrayList<E> queue = new ArrayList<>();

    public synchronized E getElement() {
        if (this.queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        return this.queue.remove(0);
    }

    public synchronized void addElement(E element) {
        this.queue.add(element);
        notify();
    }
}
