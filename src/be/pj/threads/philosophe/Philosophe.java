package be.pj.threads.philosophe;

import be.pj.threads.philosophe.states.EatingState;
import be.pj.threads.philosophe.states.HungryState;
import be.pj.threads.philosophe.states.State;
import be.pj.threads.philosophe.states.ThinkingState;

import java.util.Random;

public class Philosophe implements Runnable {
    private String name;
    private int nbOfBite;
    private State currentState;
    private Spoon leftSpoon;
    private Spoon rightSpoon;
    private Random randomFactor;

    public Philosophe(String name, int nbOfBite, Spoon leftSpoon, Spoon rightSpoon) {
        this.name = name;
        this.nbOfBite = nbOfBite;
        this.currentState = new ThinkingState();
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
        this.randomFactor = new Random();
    }

    private void setState(State s) {
        this.currentState = s;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= this.nbOfBite) {
            if (this.currentState instanceof ThinkingState) {
                long duration = Math.abs(this.randomFactor.nextLong()) % 10 * 1000;
                System.out.printf("%s is currently %s during %d ms\n", this.name, this.currentState.getStateName(), duration);
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ignored) {
                }
                this.setState(new HungryState());
                System.out.printf("%s is now %s\n", this.name, this.currentState.getStateName());
            } else if (this.currentState instanceof HungryState) {
                System.out.printf("%s is currently %s\n", this.name, this.currentState.getStateName());
                this.leftSpoon.takeSpoon();
                this.rightSpoon.takeSpoon();
                System.out.printf("%s took the spoons\n", this.name);
                this.setState(new EatingState());

            } else if (this.currentState instanceof EatingState) {
                long duration = Math.abs(this.randomFactor.nextLong()) % 10 * 1000;
                System.out.printf("%s is currently %s during %d ms\n", this.name, this.currentState.getStateName(), duration);
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ignored) {
                }
                this.nbOfBite--;
                System.out.printf("%s has now eaten. It remains %d bites\n", this.name, this.nbOfBite);
                leftSpoon.releaseSpoon();
                rightSpoon.releaseSpoon();
                this.setState(new ThinkingState());
            }
        }
        System.err.printf("%s has eaten!", this.name);

    }
}
