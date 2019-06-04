package be.pj.threads.philosophe.boulets;


import java.util.concurrent.Semaphore;

public class MainBoulet {
    public static void main(String[] args) {
        Casserole c1 = new Casserole();
        Casserole c2 = new Casserole();
        Casserole c3 = new Casserole();
        Casserole c4 = new Casserole();
        Casserole c5 = new Casserole();
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                c1.addElement(new Boulet());
            } else if (i % 5 == 1) {
                c2.addElement(new Boulet());
            } else if (i % 5 == 2) {
                c3.addElement(new Boulet());
            } else if (i % 5 == 3) {
                c4.addElement(new Boulet());
            } else {
                c5.addElement(new Boulet());
            }
        }
        Semaphore semaphore = new Semaphore(100);
        PhilosopheWallon jm = new PhilosopheWallon(c1, c2, "Jean-Mi", semaphore);
        PhilosopheWallon rene = new PhilosopheWallon(c2, c3, "René", semaphore);
        PhilosopheWallon jp = new PhilosopheWallon(c3, c4, "Jean-Pierre", semaphore);
        PhilosopheWallon jc = new PhilosopheWallon(c4, c5, "JC", semaphore);
        PhilosopheWallon claudy = new PhilosopheWallon(c5, c1, "Claudy", semaphore);


        new Thread(jm).start();
        new Thread(rene).start();
        new Thread(jp).start();
        new Thread(jc).start();
        new Thread(claudy).start();
    }
}
