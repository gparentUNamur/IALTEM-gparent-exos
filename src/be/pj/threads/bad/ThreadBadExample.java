package be.pj.threads.bad;

import java.util.ArrayList;

public class ThreadBadExample implements Runnable {

    private Account account;

    public ThreadBadExample(Account a) {
        this.account = a;
    }

    public static void main(String[] args) {
        ArrayList<Runnable> runnables = new ArrayList<>();
        Account a = new Account();
        for (int i = 0; i < 100; i++) {
            runnables.add(new ThreadBadExample(a));
        }
        for (Runnable r : runnables) {
            new Thread(r).start();
        }


    }

    @Override
    public void run() {
        synchronized (account) {
            account.add(1);
        }
    }
}
