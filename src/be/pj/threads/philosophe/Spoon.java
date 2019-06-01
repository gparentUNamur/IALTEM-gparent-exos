package be.pj.threads.philosophe;

public class Spoon {
    private boolean available = true;

    public synchronized void takeSpoon() {
        if (this.available) {
            this.available = false;
        } else {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
    }

    public synchronized void releaseSpoon() {
        this.available = true;
        notify();
    }
}
