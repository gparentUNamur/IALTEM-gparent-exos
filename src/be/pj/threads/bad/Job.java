package be.pj.threads.bad;

public class Job implements Runnable {
    private Account account;

    public Job(Account account) {
        this.account = account;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        try {
            this.account.remove(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
