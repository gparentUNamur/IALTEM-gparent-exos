package be.pj.patterns.observer;

public class SampleVisitor {
    public static void main(String[] args) {
        Radar r = new Radar();

        Cop michel = new Cop(r, "Michel");

        Cop roger = new Cop(r, "Roger");

        RadarUpdater radarUpdater = new RadarUpdater(r);
        new Thread(radarUpdater).start();

    }
}
