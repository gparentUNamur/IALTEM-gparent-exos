package be.pj.threads.bad;

public class Account {
    private int amount = 0;
    private Person owner = new Person("Jean");

    public void remove(int amount) throws Exception {
        if (amount > this.amount) {
            throw new Exception("Not possible to go in negative amount");
        }
        this.amount -= amount;
        this.printInfo();
    }

    public void add(int amount) {
        this.amount += amount;
        this.printInfo();
    }

    private void printInfo() {
        System.out.println(this.owner.getName() + " has now " + this.amount + " on his account");
    }

}
