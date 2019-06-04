package be.pj.threads.philosophe.boulets;

import java.util.Random;

public class Boulet {
    // This is a "Boulet Sauce Lapin" ;)
    private Random randomFactor = new Random();

    public boolean isWarm() {
        return this.randomFactor.nextBoolean();

    }
}
