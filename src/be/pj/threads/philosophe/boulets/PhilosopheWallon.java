package be.pj.threads.philosophe.boulets;


import java.util.concurrent.Semaphore;

public class PhilosopheWallon implements Runnable {

    private Casserole droite;
    private Casserole gauche;
    private String name;
    private final Semaphore semaphore;

    public PhilosopheWallon(Casserole droite, Casserole gauche, String name, Semaphore semaphore) {
        this.droite = droite;
        this.gauche = gauche;
        this.name = name;
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        while (this.semaphore.availablePermits() != 0) {
            Boulet b = droite.getElement(this.semaphore);
            if (b != null && b.isWarm()) {
                System.out.printf("%s eat a Boulet\nValue of semaphore : %d\n", this.name, this.semaphore.availablePermits());
                try {
                    this.semaphore.acquire();
                } catch (InterruptedException ignored) {
                }
            } else if (b != null) {
                System.out.printf("%s has a  cold Boulet, set in the left Casserole\nValue of semaphore : %d\n", this.name, this.semaphore.availablePermits());
                gauche.addElement(b);
            }
        }
        System.out.println(this.name + " Finished, Value of semaphore : " + this.semaphore.availablePermits());
    }
}
