package be.pj.patterns.visitor;

public class Cop implements Observer {

    private Radar observable;
    private String name;

    public Cop(Radar o, String name) {
        o.addObserver(this);
        this.observable = o;
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(this.name + " Notified of speed : " + this.observable.getLastDetection());
    }
}
