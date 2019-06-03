package be.pj.patterns.observer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RadarUpdater implements Runnable {
    private Radar radar;
    private Random randomFactor = new Random();

    public RadarUpdater(Radar r) {
        this.radar = r;
    }

    @Override
    public void run() {
        AtomicInteger i = new AtomicInteger();
        while (i.get() < 10) {
            try {
                Thread.sleep(Math.abs(this.randomFactor.nextLong()) % 10 * 1000);
            } catch (InterruptedException ignored) {
            }
            this.radar.detectRoadhog(Math.abs(this.randomFactor.nextInt() % 200));
            i.getAndIncrement();
        }
    }
}
